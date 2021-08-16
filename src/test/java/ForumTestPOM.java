import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class ForumTestPOM {
    private WebDriver driver = Util.getDriver();


//Main_page





        @Test
        @DisplayName("Regisztrálás az Index fórumra")
        public void Register() {
            Main_page.register();
        }


        @Test
        @DisplayName("Belépés az Index fórumra")
        public void Login_function() {
            Main_page.login();


        }


        @Test
        @DisplayName("Kijelentkezés az Index fórumról")
        public void Logging_out() {
            Main_page.login();
            Main_page.logout();
        }


        @Test
        @DisplayName("Bejelentkezési adatok beolvasása fájlból")
        public void Read_from_file() {
            Main_page.fileread();

        }


        @Test
        @DisplayName("Szöveg kinyerése weboldalról és console-ba való kiprintelése")
        public void Print_text_from_main_page() {
            Main_page.getText();
        }


        //Forum
         @Test
            @DisplayName("Fórum keresési találatok kilistázása")
            public void List_information() {
                Forum.ListData();
            }

            @Test
            @DisplayName("Fórum keresési találatokon keresztül történő loopolás")
            public void loop_through_list() {
                Forum.ListLooping();

            }


            @Test
            @DisplayName("Egyidejűleg több keresési fogalom beolvasása fájlból")
            public void read_multiple_info() {
                Forum.readfromfile();

            }


            //Settings

            @Test
            @DisplayName("Profil információk hozzáadása")
            public void add_profile_information() {
                Main_page.login();
                Profile.Add_data();

            }


            @Test
            @DisplayName("Profil információk módosítása")
            public void modify_profile_informations() {
                Main_page.login();
                Profile.modify_data();
            }


            @Test
            @DisplayName("Profil információk eltávolítása")
            public void remove_information() {
                Main_page.login();
                Profile.DataRemove();
            }


            @Test
            @DisplayName("Adatvédelmi információk szövegfájlba történő kiírása")
            public void writeprivacytextintodocument() {
                Privacy_Page.save_privacy_text();


            }





    @AfterEach
    public void Close()
    {
        //Driver dispose
        driver.quit();
    }


}
























