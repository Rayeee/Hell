package com.hell.bean.staticthis;

import com.hell.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Rayee on 16/4/22.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("bean.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        Resource resource = new InputStreamResource(fileInputStream);
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Person person = (Person) beanFactory.getBean("personStaticFactory");
    }
}
