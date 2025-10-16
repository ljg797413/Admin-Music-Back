//package kr.co.kh.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.transaction.TransactionFactory;
//import org.apache.ibatis.datasource.pooled.PooledDataSource;
//import org.apache.ibatis.session.Configuration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import javax.sql.DataSource;
//
//@Configuration
//public class MyBatisConfig {
//
//    // SqlSessionFactory 생성
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        // SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory 생성
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//
//        // MyBatis 설정을 위한 Configuration 객체 생성
//        Configuration configuration = new Configuration();
//
//        // TypeHandler 등록
//        configuration.getTypeHandlerRegistry().register(MyCustomTypeHandler.class);
//
//        // SqlSessionFactory 생성
//        SqlSessionFactory factory = builder.build(dataSource, configuration);
//
//        return factory;
//    }
//
//    // DataSource 빈 설정 (예: HikariCP 사용)
//    @Bean
//    public DataSource dataSource() {
//        // DataSource 설정 (이 부분은 실제 사용하는 DB에 맞게 설정)
//        PooledDataSource dataSource = new PooledDataSource();
//        dataSource.setDriver("org.h2.Driver");  // 사용하려는 JDBC 드라이버
//        dataSource.setUrl("jdbc:h2:mem:testdb");  // 테스트용 DB URL
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//}