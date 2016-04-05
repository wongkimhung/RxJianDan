
package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    //数据库的版本号
    public static final int DATA_VERSION_CODE = 1;
    //辅助文件的包名
    public static final String PACKAGE_NAME = "com.rtfs.greendao";
    //辅助文件生成的相对路径
    public static final String DAO_PATH = "/mnt/extra/code/as/RxJianDan/app/src/main/java-gen";

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(DATA_VERSION_CODE, PACKAGE_NAME);

        addCache(schema, "JokeCache");
        addCache(schema, "NewsCache");
        addCache(schema, "PictureCache");
        addCache(schema, "GirlCache");
        addCache(schema, "VideoCache");
        new DaoGenerator().generateAll(schema, DAO_PATH);
    }

    /**
     * 添加不同的缓存表
     *
     * @param schema
     * @param tableName
     */
    public static void addCache(Schema schema, String tableName) {
        Entity entity = schema.addEntity(tableName);
        //主键自增长
        entity.addIdProperty().primaryKey().autoincrement();
        //添加列名
        entity.addStringProperty("result");
        entity.addIntProperty("page");
        entity.addLongProperty("time");
    }
}