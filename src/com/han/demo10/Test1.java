package com.han.demo10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.*;


public class Test1 implements Serializable {
    
    public static void main(String[] args) {
        Connection con = null;
        /**
         * 1. forName(String name)方法 使用给定的字符串名称返回与类或接口关联的Class对象 （在Class对象中）
         *          参数：
         *              所需类的完全限定名
         * 2. getConnection(String url, String user, String password)方法 尝试建立与给定数据库URL连接 （在DriverManager对象中）
         *          参数：
         *              url:格式为jdbc:subprotocol:subname的数据库
         *              user:代表建立连接的数据库用户
         *              password:这个用户的密码
         * 3. prepareStatement(String sql)方法 创建一个PrepareStatement对象，用于将参数化的SQL语句发送到数据库 （在Connection对象中）
         * 4. setString(int parameterIndex, String x)方法 将指定参数设置为给定的Java String值 （在PreparedStatement对象中）
         * 5. setBinaryStream(int parameterIndex,InputStream x)方法 将指定的参数设置为给定的输入流 （在PreparedStatement中）
         * 6. executeLargeUpdate()方法 在此PreparedStatement对象中执行SQL语句，该对象必须是SQL数据操作语言（DML)语句，
         *                              例如：insert，update，delete；或者不返回任何内容的SQL语句 ，如DDL语句。（在PreparedStatement对象中）
         * 7.
         */
        try {
            //1.加载驱动（java 6以上可以忽略）
//            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            con = DriverManager.getConnection("jdbc:mysql://129.211.15.108:3306/testdb", "han", "1234");
            //3.创建语句对象
            PreparedStatement pSql = con.prepareStatement("insert into tb_user values (DEFAULT ,?,?)");
            pSql.setString(1, "时候");
            try(FileInputStream stream = new FileInputStream("D:\\han\\src\\com\\han\\demo10\\import.jpg")){
                pSql.setBinaryStream(2,stream);
                //4.发出SQL语句获得受影响的行数
                System.out.println(pSql.executeLargeUpdate() == 1 ? "插入成功":"插入失败");
            }catch (IOException e){
                System.out.println("读取照片失败！");
            }
        } catch (SQLException e ) {//java 7 多异常捕获
            e.printStackTrace();
        } finally { //释放外部资源的代码都应当放在finally中保证能够得到执行
            try {
                if (con != null && !con.isClosed()){
                    con.close(); //5.释放数据库连接
                    con = null; //指示垃圾回收器可以回收该对象
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
