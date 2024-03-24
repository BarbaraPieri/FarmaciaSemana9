import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        // Configuração do Flyway
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/farmacia", "root", "9_NhBgXr14@2").load();

        // Executa o comando repair
        flyway.repair();

        // Restante da lógica da sua aplicação...
    }
}