import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost/voti?user=root&password=Pass4cas0";
		
		//identifica connessione db
		try {
			//aprire una connessione se possibile
			Connection conn= DriverManager.getConnection(jdbcURL);
			
			Statement st=conn.createStatement();
			String sql ="SELECT nome,voto " +
					"FROM libretto "+
					"ORDER BY voto DESC";
			ResultSet res=st.executeQuery(sql);
			
			while(res.next()) {
				String nome=res.getString("nome");
				int voto=res.getInt("voto");
				System.out.format("Voto %d dell'esame %s \n", voto, nome);
			}
			st.close();
			//se no ci possono essere problemi e non ci fa più fare connessioni
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
