package com.example.javajaxbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

@SpringBootApplication
public class JavaJaxbExampleApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(JavaJaxbExampleApplication.class, args);

		JAXBContext jaxbContext = JAXBContext.newInstance(SampleClass.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader("<SampleClass><Name>abcd</Name><Email>abcd@abcd.com</Email></SampleClass>");
		SampleClass sampleClass = (SampleClass) unmarshaller.unmarshal(reader);
		System.out.println("XML to Object =>"+sampleClass);
	}



	@XmlRootElement(name="SampleClass")
	public static class SampleClass {
		@XmlElement(name="Name")
		private String name;
		@XmlElement(name="Email")
		private String email;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "SampleClass{" +
					"name='" + name + '\'' +
					", email='" + email + '\'' +
					'}';
		}
	}
}
