连接数据库操作：

1、第一步导入jar包
mysql的jar包 
2、加载驱动：
	Class.forName("com.mysql.jdbc.Driver");
3、获取连接：通过DriverManager获取连接
    Connection conn = DriverManager.getConnection(url, dbName, dbpass);
		uri:'jdbc:mysql://localhost:3306/wc?useUnicode=true&characterEncoding=UTF-8'
							数据库端口号 数据库名   使用unicode编码  使用UTF-8解码
		dbName: 连接用户名
		dbpass：连接密码
4、编写sql语句：
	String sql = "SELECT * FROM user WHERE id = ?";
	
5、获取预编译对象:(预编译，还未执行sql语句，id=？还未设置参数)
	PreparedStatement ps = conn.prepareStatement(sql);
6、绑定参数：（设置第一个？是1）
	ps.setString(1,"1");
		第几个问号  设置的参数
7、执行sql语句：(executeQuery这才是真的执行sql语句)
	ResultSet rs = ps.executeQuery();
	(executeQuery是执行查询操作，会返回一个ResultSet结果集)
	int rows = ps.executeUpdate();//执行修改操作会返回一个受影响的行数
8、循环遍历结果集：
	while(rs.next()){
		rs.getInt(字段名，或者是下标);
		rs.getInt(1);//返回第一个参数
		rs.getString(1);//返回第一个参数
		rs.getString("id");//返回一个id的字段值
		rs.getString("id");//返回一个id的字段值
	}