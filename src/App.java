import javax.swing.JOptionPane; //JOptionPane used to take user input and display messages
import java.util.Objects;

public class App
{

    public static void main(String[] args)
    {

        //Ask user for their name
        String Name = JOptionPane.showInputDialog("Enter your first name:");
        //Ask user for their username
        String Surname = JOptionPane.showInputDialog("Enter your last name:");
        //lets me get username variable's input later for login
        String username; //lets me take input for later

        boolean checkUserName;
        do
        {

            username = JOptionPane.showInputDialog("Create username that contains: \nAn underscore_ \n5 characters");
            int userSize = username.length(); //get user length

            boolean checkUserLength = userSize >= 5; //make sure user is 5 characters long
            boolean checkUserSpecial = false; //set the character is _ condition to false so the base state is false

            for (char UsernameCharacters : username.toCharArray()) //goes over each character in the username
            {
                if ("_".contains(String.valueOf(UsernameCharacters))) //checks if the character in the username is an _ by converting each character to a string
                {
                    checkUserSpecial = true;
                    break;
                }
            }

            checkUserName = checkUserLength && checkUserSpecial;


            if (checkUserName)
            {
                String registerUser = "Username successfully captured";
                //When the username is right then say success message
                JOptionPane.showMessageDialog(null, registerUser);
            }
            else
            {
                String registerUser = "Username is not correctly formatted.\nPlease ensure that your username contains: \nAn underscore \n5 characters";
                //When the username isn't right then say fail message
                JOptionPane.showMessageDialog(null, registerUser);
            }
        }
        while (!checkUserName);





        String password; //So I can grab the password for later
        boolean checkPasswordComplexity;

        do
        {

            password = JOptionPane.showInputDialog("""
                    Create password, your password must be:
                    8 characters
                    a capital letter
                    a number
                    a special character.""");
            int passwordSize = password.length();

            boolean checkPasswordLength = passwordSize >= 8; //checks password length
            boolean checkPasswordSpecial = false;
            boolean checkPasswordCapital = false;
            boolean checkPasswordNumber = false;

            for (char PasswordCharacters : password.toCharArray())
            {
                if ("!@#$%^&*<>?".contains(String.valueOf(PasswordCharacters)))
                { //check for special characters that can be typed by a computer keyboard
                    checkPasswordSpecial = true;
                }
                else if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(PasswordCharacters)))
                { //check for capital letter
                    checkPasswordCapital = true;
                }
                else if ("1234567890".contains(String.valueOf(PasswordCharacters)))
                { //check for number
                    checkPasswordNumber = true;
                }
            }

            checkPasswordComplexity = checkPasswordLength && checkPasswordSpecial && checkPasswordCapital && checkPasswordNumber;

            if (checkPasswordComplexity)
            {
                String registerUser = "Password successfully captured";
                //if password is good show success message
                JOptionPane.showMessageDialog(null, registerUser);
            }
            else
            {
                String registerUser = """
                        Password is not correctly formatted,\s
                        please ensure that the password contains at least:
                        8 characters
                        a capital letter
                        a number
                        a special character.""";
                //if password isn't good show fail message
                JOptionPane.showMessageDialog(null, registerUser);
            }
        }
        while (!checkPasswordComplexity);






        boolean checkLogIn = false;
        do //do while loop so that the user only has to redo the incorrect thing and not everything
        {
            String UsernameLogin = JOptionPane.showInputDialog("Welcome! Please enter your username to log in:");
            boolean UsernameCorrect = Objects.equals(UsernameLogin, username);

            if (!UsernameCorrect)
            {
                String LoginFail = "Your Username is incorrect. Please try again.";
                JOptionPane.showMessageDialog(null, LoginFail);
                continue;
            }

            String PasswordLogin = JOptionPane.showInputDialog("Welcome! Please enter your password to log in");
            boolean PasswordCorrect = Objects.equals(PasswordLogin, password);

            if (!PasswordCorrect)
            {
                String LoginFail = "Your password is incorrect. Please try again.";
                JOptionPane.showMessageDialog(null, LoginFail);
                continue;
            }

            checkLogIn = UsernameCorrect && PasswordCorrect;

        }
        while (!checkLogIn);

        String LoginSuccess = "Welcome " + Name + " " + Surname + "! Good to see you again!";
        JOptionPane.showMessageDialog(null, LoginSuccess);








                            //part 1 and part 2 split






        //my code will not move to this step or any other step unless the correct inputs are made, so we assume that the user is logged in successfully and can make tasks
        boolean SelectedQuit = false;
        int totalDuration = 0;
        //this while means that unless they say quit, the code will not quit.
        while (!SelectedQuit)
        {
            String SelectedOption = JOptionPane.showInputDialog("Welcome to EasyKanban! Type 1 to Add Tasks. Type 2 to Show Report Coming soon. Type 3 to Quit");

            if (Objects.equals(SelectedOption, "1"))
            {
                String Option1Select = "Add Task selected";
                JOptionPane.showMessageDialog(null, Option1Select);

                String NumTaskMaking = JOptionPane.showInputDialog("Please enter how many Tasks you wish to add today");
                int i = Integer.parseInt(NumTaskMaking); //make the number of tasks an integer to use as variable
                int t = 0; //t is the task number, which starts at 0

                while (i > 0) //while the number of tasks they want is more than 0
                {
                    String EnterTaskName = JOptionPane.showInputDialog("Please name your task");

                    String EnterTaskDescription;
                    boolean ValidDescription;
                    do
                    {
                        EnterTaskDescription = JOptionPane.showInputDialog("Please describe your task in 50 characters or less");
                        int DescriptionSize = EnterTaskDescription.length();
                        ValidDescription = DescriptionSize <= 50;
                        if (!ValidDescription)
                        {
                            String DescriptionBad = "Please shorten your description, it may not exceed 50 characters";
                            JOptionPane.showMessageDialog(null, DescriptionBad);
                        }
                    }
                    while (!ValidDescription);

                    String EnterDevName = JOptionPane.showInputDialog("Please enter your name");
                    String EnterDevSurname = JOptionPane.showInputDialog("Please enter your surname");
                    String TaskDuration = JOptionPane.showInputDialog("How long will this task take? Please enter the time in hours (nu text units)");
                    String TaskStatus = JOptionPane.showInputDialog("What is the status of this task?\n1) To do\n2) Done\n3) Doing");

                    //this code assigns the correct status to the TaskStatusOut variable so its displayed right
                    String TaskStatusOut;
                    if (Objects.equals(TaskStatus, "1"))
                    {
                        TaskStatusOut = "To Do";
                    }
                    else if (Objects.equals(TaskStatus, "2"))
                    {
                        TaskStatusOut = "Done";
                    }
                    else
                    {
                        TaskStatusOut = "Doing";
                    }

                    //this code makes the Task ID by grabbing the first 2 letters of the TaskName and lest 3 letters of EnterDevName using substring.
                    String TaskID = EnterTaskName.substring(0,2) + ":" + t + ":" + EnterDevName.substring(EnterDevName.length() - 3);
                    //To make the ID capitalised
                    TaskID = TaskID.toUpperCase();
                    //need to decrease i since it's the number of tasks they want to make, crossing off task entries basically
                    i--;

                    int taskDurationHours = Integer.parseInt(TaskDuration);
                    //This creates the variable that will hold and add together all the times
                    totalDuration += taskDurationHours;
                    //adds each new time duration to total

                    //this code is the output message
                    String OutputDetails = "Here are the details of your task:"
                            + "\nTask status: " + TaskStatusOut
                            + "\nDeveloper details: " + EnterDevName + " " + EnterDevSurname
                            + "\nTask number: " + t
                            + "\nTask Name: " + EnterTaskName
                            + "\nTask Description: " + EnterTaskDescription
                            + "\nTask ID: " + TaskID
                            + "\nTask duration: " + TaskDuration + " hours";

                    JOptionPane.showMessageDialog(null, OutputDetails);
                    t++;

                    //will display after every entry, unsure if this is good or not
                    String totalDurationMessage = "Total time: " + totalDuration + " hours";
                    JOptionPane.showMessageDialog(null, totalDurationMessage);


                }


            }
            else if (Objects.equals(SelectedOption, "2"))
            {
                String Option2Select = "See Report selected";

                JOptionPane.showMessageDialog(null, Option2Select);
                //break;
                //optional break to close program after selecting 2
            }
            else
            {
                String Option3Select = "Goodbye!";
                JOptionPane.showMessageDialog(null, Option3Select);
                SelectedQuit = true;
            }


        }

    }
}