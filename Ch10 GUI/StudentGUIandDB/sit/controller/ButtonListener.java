package sit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JTextField;
import sit.model.Student;

public class ButtonListener implements ActionListener{
    private JTextField txtStdId;
    private JTextField txtStdFirstName;
    private JTextField txtStdLastName;

    public ButtonListener(JTextField txtStdId, JTextField txtStdFirstName, JTextField txtStdLastName) {
        this.txtStdId = txtStdId;
        this.txtStdFirstName = txtStdFirstName;
        this.txtStdLastName = txtStdLastName;
    }
    
    //เช็คว่าปุ่มไหนทำงาน
    @Override
    public void actionPerformed(ActionEvent e) {
        //ปุ่มไหนที่ถูกทำงาน return String
        String btnCommand=e.getActionCommand();
        if(btnCommand.equalsIgnoreCase("Reset")){
            reset();
        }else if(btnCommand.equalsIgnoreCase("Save")){
            save();
        }else if(btnCommand.equalsIgnoreCase("Save As Object")){
            saveAs();
        }
    }
    
    //Clear textfield
    public void reset(){
            txtStdId.setText("");
            txtStdFirstName.setText("");
            txtStdLastName.setText("");
    }
    
    //data OutputStream
    public void saveAs(){
        try{
            FileOutputStream fos=new FileOutputStream("student-object.dat");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            //get from text field
            int stdId= Integer.parseInt(txtStdId.getText());    //change id from String to Int by parseInt
            String stdFirstName = txtStdFirstName.getText();
            String stdLastName = txtStdLastName.getText();
            //field--->object
            Student std=new Student(stdId,stdFirstName,stdLastName);
            //write object
            oos.writeObject(std);
            //close stream
            oos.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println(fnf);
        }catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
    public void save(){
        try{
            FileOutputStream fos=new FileOutputStream("student.dat",true);
            DataOutputStream dos=new DataOutputStream(fos);
            //write int--> change id from String to Int by parseInt
            dos.writeInt(Integer.parseInt(txtStdId.getText()));
            //write String-->UTF
            dos.writeUTF(txtStdFirstName.getText());
            dos.writeUTF(txtStdLastName.getText());
            //close stream
            dos.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println(fnf);
        }catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
}
