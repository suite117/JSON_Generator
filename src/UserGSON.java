import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class UserGSON {
	public static void main(String[] args) {

		FileUtils file = new FileUtils("nomi.txt");
		file.openRead();

		List<Persona> users = new ArrayList<Persona>();
		String line;
		int i = 0;
		while ((line = file.readLine()) != null) {
			Persona user = new Persona();
			user.setId(i);
			i++;
			//user.setName(line);
			//user.setSurname(line);
			users.add(user);
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
