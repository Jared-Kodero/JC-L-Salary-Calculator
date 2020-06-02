import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.scene.layout.GridPane; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; 
import javafx.geometry.Pos; 
import javafx.geometry.HPos; 
import javafx.scene.text.*; 
import javafx.geometry.Insets;
public class JC extends Application {    
    
    public static void main(String[] args)
    {  
        launch(args);     } 
        
        //Create Text Fields UI
        
    private TextField tfDriverName = new TextField();
    private TextField tfAmbulatoryT1 = new TextField();  
    private TextField tfAmbulatoryT2 = new TextField();   
    private TextField tfWheelChairT1 = new TextField();  
    private TextField tfWheelChairT2 = new TextField();  
    private TextField tfStretcherT1 = new TextField(); 
    private TextField tfStretcherT2 = new TextField();
    private TextField tfSalary = new TextField();
    
    private Button btCalculate = new Button("Calculate");  

    @Override     public void start(Stage primaryStage) {    
        // Create UI      
        primaryStage.setTitle("JC & L Salary Calculator");

        primaryStage.show();

        GridPane gridPane = new GridPane();    
        gridPane.setHgap(20);         
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(gridPane, 500, 500);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("JC and L Salary Management Software");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(scenetitle, 0, 0, 2, 1);
        
        gridPane.add(new Label("Driver Name:"), 0, 1);    
        gridPane.add(tfDriverName, 1, 1);
        
        Text scenelabel = new Text("Enter the total number of miles driven for:");
        scenelabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        gridPane.add(scenelabel, 0, 1, 1, 3);
        
        gridPane.add(new Label("Ambulatory Trip 1:"), 0, 3);    
        gridPane.add(tfAmbulatoryT1, 1, 3);       
        gridPane.add(new Label("Ambulatory Trip 2:"), 0, 4);     
        gridPane.add(tfAmbulatoryT2, 1, 4);      
        gridPane.add(new Label("WheelChair Trip 1:"), 0, 5);      
        gridPane.add(tfWheelChairT1, 1, 5);     
        gridPane.add(new Label("WheelChair Trip 2:"), 0,6);     
        gridPane.add(tfWheelChairT2, 1, 6);

        gridPane.add(new Label("Stretcher Trip 1:"), 0, 7);   
        gridPane.add(tfStretcherT1, 1, 7); 
        
        gridPane.add(new Label("Stretcher Trip 2:"), 0, 8);   
        gridPane.add(tfStretcherT2, 1, 8); 
        gridPane.add(btCalculate, 1, 9); 
        
        gridPane.add(new Label("Total Salary:"), 0, 10);   
        gridPane.add(tfSalary, 1, 10);     


        btCalculate.setOnAction(e -> calculateSalary()); 
          
        primaryStage.setScene(scene);     
        primaryStage.show();   
    }    

    private void calculateSalary() {     
        // Get values from text fields      
        double Millage = Double.parseDouble(tfAmbulatoryT1.getText());       
        double MillageRound = Double.parseDouble(tfAmbulatoryT2.getText()); 
        double TMillage;
        
        double Millage2 = Double.parseDouble(tfWheelChairT1.getText());       
        double Millage2Round = Double.parseDouble(tfWheelChairT2.getText()); 
        double TMillage2;
        
        double Millage3 = Double.parseDouble(tfStretcherT1.getText());       
        double Millage3Round = Double.parseDouble(tfStretcherT2.getText()); 
        double TMillage3;
        
        double salaryAmb = 0.0;
        double salaryWheel = 0.0;
        double salarySRA = 0.0;
        double Stretcher = 0.0;
        double TSalary = 0.0;
        double PayRate = 0.25;
              
        
         TMillage= Millage + MillageRound;

        // Salary Calculator algorithm
        if (TMillage == 0)
            salaryAmb = 0; 

        else

        if (TMillage >0 && TMillage <= 3)
            salaryAmb = 8.75;

        else
        {
            if (TMillage > 3 && TMillage <= 6)

                salaryAmb = 11.00;

            if (TMillage > 6 && TMillage <= 10)
                salaryAmb = 14.70;
                
            if (TMillage > 10)
                salaryAmb = (14.70) + (1.30 * (TMillage - 10));
        }

        double Tamb = (salaryAmb * PayRate );
        
        // WheelChair Salary
        
        TMillage2 = Millage2 + Millage2Round;

        if (TMillage2 == 0)

            salaryWheel = 0;

        else
        if (TMillage2 > 0 && TMillage2 <= 3)
            salaryWheel = 17.80;
        else
        {
            if (TMillage2 > 3 && TMillage2 <= 6)

                salaryWheel = 20.25;

            if (TMillage2 > 6 && TMillage2 <= 10)
                salaryWheel = 23.80;
            if (TMillage2 > 10)
                salaryWheel = 23.80 + (1.50 * (Millage2 - 10));
        }

        double TWheel = (salaryWheel * PayRate);
        
        //Streatcher Salary
        
        
        if (Millage3 == 0)

            Stretcher = 0;

        else 
        {if (Millage3 > 0 && Millage3 <= 3)
                Stretcher = 150;
            else
                Stretcher = 150 + (2.50 * (Millage3 - 10)); }

        double Ts = (Stretcher*PayRate);
        
        TSalary = Tamb + TWheel + Ts;
        
        //Display Results

        //tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));    
        tfSalary.setText(String.format("$%.2f",TSalary));   
        
         

    }     

    
} 
