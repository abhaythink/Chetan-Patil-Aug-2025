package com.thinkitive.springboot_rest_api.thinkitive_restful_web_services.helloWord;

public class HelloWorldBean
{

    private String mes;
    public HelloWorldBean(String mes) {
        this.mes = mes;
    }



    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "mes='" + mes + '\'' +
                '}';
    }


}
