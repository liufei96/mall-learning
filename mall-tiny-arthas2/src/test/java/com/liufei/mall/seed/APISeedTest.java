package com.liufei.mall.seed;

import com.google.common.base.CaseFormat;
import com.liufei.mall.seed.core.ProjectConstant;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author liufei
 * @version 1.0.0
 * @description apiSeed 代码生成器
 * @date 2022/9/4
 */
public class APISeedTest {

    private final static Logger log = LoggerFactory.getLogger(APISeedTest.class);

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/mall-tiny-arthas2";

    private static final String JAVA_PATH = PROJECT_PATH + "/src/main/java";

    private static final String RESOURCES_PATH = PROJECT_PATH + "/src/main/resources";

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(ProjectConstant.SERVICE_PACKAGE);

    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(ProjectConstant.SERVICE_IMPL_PACKAGE);

    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(ProjectConstant.CONTROLLER_PACKAGE);

    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/generator/template";

    private static final String DATE = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    private static final String[] JUDGE_FIELDS = {
            "is_deleted"
    };

    private static Properties properties = null;


    public static void main(String[] args) throws IOException {
        initGenerateConfig();
        List<String> jdbcTables = readTableNames();
        for (String table : jdbcTables) {
            generateCode(table);
        }
    }

    private static void initGenerateConfig() throws IOException {
        InputStream is = APISeedTest.class.getResourceAsStream("/generator.properties");
        properties = new Properties();
        properties.load(is);
        System.out.println(properties);
    }

    private static JDBCConnectionConfiguration getJDBCConnectionConfiguration() {
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(properties.getProperty("jdbc.connectionURL"));
        jdbcConnectionConfiguration.setUserId(properties.getProperty("jdbc.userId"));
        jdbcConnectionConfiguration.setPassword(properties.getProperty("jdbc.password"));
        jdbcConnectionConfiguration.setDriverClass(properties.getProperty("jdbc.driverClass"));
        return jdbcConnectionConfiguration;
    }

    private static PluginConfiguration getSerializablePluginConfiguration() {
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        return pluginConfiguration;
    }

    private static JavaModelGeneratorConfiguration getJavaModelGeneratorConfiguration() {
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(ProjectConstant.MODEL_PACKAGE);
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "true");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        return javaModelGeneratorConfiguration;
    }

    private static PluginConfiguration getMapperPluginConfiguration() {
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        return pluginConfiguration;
    }

    private static void generateCode(String... tableNames) {
        String jdbcTablePrefix = properties.getProperty("jdbc.table.prefix");
        for (String tableName : tableNames) {
            String modelName = null;
            if (StringUtils.isBlank(jdbcTablePrefix)) {
               continue;
            }
            String[] jdbcTablePrefixs = jdbcTablePrefix.split(",");
            Set<String> jdbcTableSet = Stream.of(jdbcTablePrefixs).collect(Collectors.toSet());
            for (String jdbcTable : jdbcTableSet) {
                modelName = tableNameConvertUpperCamel(tableName.replace(jdbcTable, ""));
                generateByCustomModelName(tableName, modelName);
            }
        }
    }

    private static void generateByCustomModelName(String tableName, String modelName) {
        generatorModelAndMapper(tableName, modelName);
        generatorService(tableName, modelName);
        generatorController(tableName, modelName);
    }

    private static void generatorModelAndMapper(String tableName, String modelName) {
        Context context = getContext(tableName, modelName);
        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration configuration = new Configuration();
            configuration.addContext(context);
            configuration.validate();

            DefaultShellCallback callback = new DefaultShellCallback(true);
            warnings = new ArrayList<>();
            generator = new MyBatisGenerator(configuration, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("generate model/mapper failed", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("generate model/mapper failed: " + warnings);
        }

        if (StringUtils.isEmpty(modelName)) {
            modelName = tableNameConvertUpperCamel(tableName);
        }

        System.out.println(modelName + ".java generate ok");
        System.out.println(modelName + "Mapper.java generate ok");
        System.out.println(modelName + "Mapper.xml generate ok");
    }

    private static Context getContext(String tableName, String modelName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("mytables");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING, "UTF-8");
        context.addProperty(PropertyRegistry.CONTEXT_JAVA_FORMATTER, "org.mybatis.generator.api.dom.DefaultJavaFormatter");

        context.setJdbcConnectionConfiguration(getJDBCConnectionConfiguration());
        context.addPluginConfiguration(getMapperPluginConfiguration());
        context.addPluginConfiguration(getSerializablePluginConfiguration());
        context.setJavaModelGeneratorConfiguration(getJavaModelGeneratorConfiguration());
        context.setSqlMapGeneratorConfiguration(getSqlMapGeneratorConfiguration());
        context.setJavaClientGeneratorConfiguration(getJavaClientGeneratorConfiguration());

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setDomainObjectName(modelName + "DOV1");
        tableConfiguration.setMapperName(modelName + "MapperV1");

        GeneratedKey generatedKey = new GeneratedKey("id", "Mysql", true, null);
        tableConfiguration.setGeneratedKey(generatedKey);


        Set<String> judgeFieldSet = Stream.of(JUDGE_FIELDS).collect(Collectors.toSet());
        for (String judgeField : judgeFieldSet) {
            ColumnOverride column = new ColumnOverride(judgeField);
            if (judgeField.startsWith("is_")) {
                judgeField = judgeField.split("is_")[1];
            }
            column.setJavaProperty(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, judgeField));

            if (judgeField.endsWith("deleted")) {
                column.setJavaType("Byte");
            } else {
                column.setJavaType("Boolean");
            }
            tableConfiguration.addColumnOverride(column);
        }
        context.addTableConfiguration(tableConfiguration);
        return context;
    }

    private static SqlMapGeneratorConfiguration getSqlMapGeneratorConfiguration() {
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper/v1");
        return sqlMapGeneratorConfiguration;
    }

    private static JavaClientGeneratorConfiguration getJavaClientGeneratorConfiguration() {
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(ProjectConstant.MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        return javaClientGeneratorConfiguration;
    }

    private static void generatorService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            Map<String, Object> data = getTemplateData(modelNameUpperCamel);
            File file = FileUtils.getFile(JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "ServiceV1.java");
            if (!file.getParentFile().exists()) {
                boolean ok = file.getParentFile().mkdirs();
                if (!ok) {
                    log.warn("mkdir {} failed", file.getParentFile());
                }
            }
            cfg.getTemplate("service.ftl").process(data, new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java generate ok");

            File file1 = FileUtils.getFile(JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImplV1.java");
            if (!file1.getParentFile().exists()) {
                boolean ok = file1.getParentFile().mkdirs();
                if (!ok) {
                    log.warn("mkdir {} failed", file1.getParentFile());
                }
            }
            cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(file1));
            System.out.println(modelNameUpperCamel + "ServiceImpl.java generate ok");
        } catch (Exception e) {
            throw new RuntimeException("generate controller failed", e);
        }
    }

    private static void generatorController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            Map<String, Object> data = getTemplateData(modelNameUpperCamel);
            File file = FileUtils.getFile(JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "ControllerV1.java");
            if (!file.getParentFile().exists()) {
                boolean ok = file.getParentFile().mkdirs();
                if (!ok) {
                    log.warn("mkdir {} failed", file.getParentFile());
                }
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

        } catch (Exception e) {
            throw new RuntimeException("generate controller failed", e);
        }
    }

    private static freemarker.template.Configuration  getConfiguration() throws IOException {
        freemarker.template.Configuration  configuration = new freemarker.template.Configuration (freemarker.template.Configuration.VERSION_2_3_23);
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        configuration.setDefaultEncoding("utf-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return configuration;
    }

    private static Map<String, Object> getTemplateData(String modelNameUpperCamel) {
        Map<String, Object> data = new HashMap<>();
        data.put("date", DATE);
        data.put("author", properties.getProperty("author"));
        data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
        data.put("modelNameUpperCamel", modelNameUpperCamel);
        data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
        data.put("basePackage", ProjectConstant.BASE_PACKAGE);
        return data;
    }

    private static String modelNameConvertMappingPath(String modelNameUpperCamel) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "V1" + modelNameUpperCamel);
        return tableNameConvertMappingPath(tableName);
    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase(Locale.getDefault());
        return "/" + (tableName.contains("_") ? tableName.replace("_", "/") : tableName);
    }

    private static List<String> readTableNames() {
        List<String> tableNameList = new ArrayList<>();
        URL url = APISeedTest.class.getClassLoader().getResource("table.txt");
        if (url == null) {
            throw new RuntimeException("table.txt file not exists");
        }
        try (FileReader fr = new FileReader(url.getPath());BufferedReader br = new BufferedReader(fr);) {
            String line = br.readLine();
            while (line != null) {
                tableNameList.add(line.trim());
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("readTableNames failed :", e);
        }
        return tableNameList;
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase(Locale.getDefault()));
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
