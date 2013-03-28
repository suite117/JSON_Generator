import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Main {


	public static void main(String[] args) {

		FileUtils file = new FileUtils("nomi.txt");
		file.openRead();

		UserDAO userDAO = new UserDAO(Persona.class);
		// User u = new User();
		List<Persona> users = null;
		try {

			users = userDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String usersJson = gson.toJson(users);
		System.out.println(usersJson);

		try {
			FileWriter writer = new FileWriter("users.json");
			writer.write(usersJson);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
