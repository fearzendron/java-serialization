package br.com.zendron.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.junit.Test;

import br.com.zendron.domain.Gender;
import br.com.zendron.domain.Person;

public class SerializationTest {

	@Test
	public void serializationToDisk() {

		double timeInMillis = 0.0;
		
		try {

			Person chucky = new Person("Fernando", "Zendron", Gender.MALE);
			Person celso = new Person("Celso", "Zendron", Gender.MALE);

			chucky.setParent(celso);

			FileOutputStream fileOutputStream = new FileOutputStream("tempdata.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			timeInMillis = (double) new Date().getTime();
			
			objectOutputStream.writeObject(chucky);
			objectOutputStream.close();

		} catch (Exception e) {
			fail("Exception is: " + e.toString());
		}

		try {

			FileInputStream fileInputStream = new FileInputStream("tempdata.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Person chucky = (Person) objectInputStream.readObject();
			
			timeInMillis -= (double) new Date().getTime();
			
			System.out.println("Tempo de seriaização e deserialização: " + (timeInMillis / 1000));
			
			objectInputStream.close();

			assertEquals("Fernando", chucky.getName());
			assertEquals("Celso", chucky.getParent().getName());

			new File("tempdata.ser").delete();

		} catch (Exception e) {
			fail("Exception is: " + e.toString());
		}

	}

}
