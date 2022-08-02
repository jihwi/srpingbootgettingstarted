package com.jihwi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.run(args);
////        SpringApplication.run(Application.class, args);
//    }

    //override되지 않고, 내가 등록한 빈 보다 autoConfiguration이 더 우선된다.
//    @Bean
//    public Holoman holoman(){
//        Holoman holoman = new Holoman();
//        holoman.setName("whiteship");
//        holoman.setHowLong(60);
//        return holoman;
//    }

    //tocmat 설정 해보기
//    public static void main(String[] args) throws LifecycleException {
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8090);
//        //context path prefix개념
//        //어플리케이션 구분을 위해 사용됨 localhost:[port]/[projectName]/[servlet url]
//        Context context = tomcat.addContext("/tomcat", "/");
//        HttpServlet servlet = new HttpServlet() {
//            @Override
//            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                PrintWriter writer = resp.getWriter();
//                writer.println("<html><head><title>");
//                writer.println("hey, tomcat");
//                writer.println("</title></head>");
//                writer.println("<body><h1> hello, tomcat </h1></body>");
//                writer.println("</html>");
//            }
//        };
//
//        String servletName = "helloServlet";
//        //context path prefix개념
//        tomcat.addServlet("/tomcat", servletName, servlet);
//        //mapping url
//        context.addServletMappingDecoded("/hello", servletName);
//
//
//        tomcat.start();
//        tomcat.getServer().await();
//    }

//    public static void main(String[] args) {
////        SpringApplication.run(Application.class, args);
//        //builder 패턴
//        new SpringApplicationBuilder()
//                .web(WebApplicationType.NONE)
//                .sources(Application.class)
//                .listeners(new SampleListner())
//                .run(args);
//    }
//
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello, spring";
//    }

    //https설정이후 http로도 받고 싶으면 다른 포트에 conector하나 더 만들기
//    @Bean
//    public ServletWebServerFactory serverFactory(){
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8090);
//        return connector;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
