package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * O construtor.
     * O construtor � chamado antes do m�todo inicialize().
     */
    public PersonOverviewController() {
    }

    /**
     * PReenche todos os campos de texto para mostrar detalhes sobre a pessoa.
     * Se a pessoa especificada for null, todos os campos de texto s�o limpos.
     * 
     * @param person a pessoa ou null
     */
    private void showPersonDetails(Person person) {
    	birthdayLabel.setText(DateUtil.format(person.getBirthday()));
    }
    
    /**
     * Inicializa a classe controller. Este m�todo � chamado automaticamente
     *  ap�s o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
    	 // Inicializa a tabela de pessoas com duas colunas.
        firstNameColumn.setCellValueFactory(
        cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
        cellData -> cellData.getValue().lastNameProperty());

        // Limpa os detalhes da pessoa.
        showPersonDetails(null);

        // Detecta mudan�as de sele��o e mostra os detalhes da pessoa quando houver mudan�a.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));    
    }

    /**
     * � chamado pela aplica��o principal para dar uma refer�ncia de volta a si mesmo.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        personTable.setItems(mainApp.getPersonData());
    }
}/*
Todos os campos e m�todos onde o arquivo fxml precisa de acesso devem ser anotados com @FXML. Na verdade, omente se eles forem private, mas � melhor t�-los private e marc�-los com a anota��o!
O m�todo initialize() � chamado automaticamente ap�s o arquivo fxml ter sido carregado. Nessa hora, todos os campos FXML j� devem ter sido inicializados.
O m�todo setCellValueFactory(...) que n�s definimos nas colunas da tabela s�o usados para determinar qual campo dentro dos objetos de Person devem ser usados para determinda coluna. A seta -> indica que n�s estamos usando um recurso do Java 8 chamado Lambdas. (Outra op��o seria usar uma PropertyValueFactory, mas esta n�o � type-safe (segura por tipo)).
*/