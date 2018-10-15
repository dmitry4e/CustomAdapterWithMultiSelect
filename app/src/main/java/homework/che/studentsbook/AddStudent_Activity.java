package homework.che.studentsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddStudent_Activity extends Activity{
    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_);
    }


    public void btnOK_Click(View view) {

        final EditText firstName_ET=findViewById(R.id.firstName_ET);
        final EditText lastName_ET=findViewById(R.id.lastName_ET);
        final EditText male_ET=findViewById(R.id.male_ET);
        final EditText group_ET=findViewById(R.id.group_ET);

        String firstName=firstName_ET.getText().toString();
        String lastName=lastName_ET.getText().toString();
        String male=male_ET.getText().toString();
        String group=group_ET.getText().toString();

        Student newStudent=new Student(firstName,lastName,male,group);

        Intent answerIntent=new Intent(this, MainActivity.class);
        answerIntent.putExtra(Student.class.getSimpleName(),newStudent);

        Log.d(TAG,"addActivity:"+newStudent.toString());

        startActivity(answerIntent);
    }
}
