import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class ForumTestPOM {
    private WebDriver driver = Util.getDriver();


//Main_page

    @Test
    public void Register() {
        Main_page.register();
    }


    @Test
    public void Login_function() {
        Main_page.login();


    }


    @Test
    public void Logging_out() {
        Main_page.login();
        Main_page.logout();
    }


    @Test
    public void Read_from_file() {
        Main_page.fileread();

    }


    @Test
    public void Print_text_from_main_page() {
        Main_page.getText();
    }


    //Forum

    @Test
    public void List_information() {
        Forum.ListData();
    }

    @Test
    public void loop_through_list() {
        Forum.ListLooping();

    }


    @Test
    public void read_multiple_info() {
        Forum.readfromfile();

    }


    //Settings

    @Test
    public void add_profile_information() {
        Main_page.login();
        Profile.Add_data();

    }


    @Test
    public void modify_profile_informations() {
        Main_page.login();
        Profile.modify_data();
    }


    @Test
    public void remove_information() {
        Main_page.login();
        Profile.DataRemove();
    }


    @Test
    public void writeprivacytextintodocument() {
        Privacy_Page.save_privacy_text();


    }

}

















