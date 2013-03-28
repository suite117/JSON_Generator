import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends DAO<Persona, Integer> {

	public PersonaDAO(Class<Persona> objectClass) {
		super(objectClass);
	}

	@Override
	public List<Persona> findAll() throws SQLException, Exception {
		List<Persona> persone = new ArrayList<Persona>();
		Persona persona = null;
		try {
			openConnection();
			String querystring = "SELECT * FROM " + "persona";

			ptmt = getConnection().prepareStatement(querystring);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				persona = new Persona();
				persona.setId(rs.getInt(1));
				persona.setNome(rs.getString(2));
				persona.setDatanascita(rs.getString(3));
				persona.setDatamorte(rs.getString(4));
				persone.add(persona);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			closeConnection();
		}

		return persone;
	}

	
	public Integer generateId() throws SQLException {
		return null;

	}

	public static void main(String[] args) {

		PersonaDAO userDAO = new PersonaDAO(Persona.class);
		// User u = new User();

		try {

			System.out.print(userDAO.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
