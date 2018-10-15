package homework.che.studentsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    private static final String TAG ="myLogs" ;
    static List<Student> students=new ArrayList<>();
    StudentBookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.StudentBook_LV);

        if(students.isEmpty()) {
            students = initData();
        }
         adapter=new StudentBookAdapter(this,students);
        listView.setAdapter(adapter);

        Bundle arguments=getIntent().getExtras();
        final Student newStudent;
        if(arguments!=null){
            newStudent=(Student) arguments.getSerializable(Student.class.getSimpleName());
            students.add(newStudent);
            adapter.updateBook(students);
            Log.d(TAG,"mainActivity:"+newStudent.toString());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student=students.get(position);
                if(student.isSelected()){
                    student.setSelected(false);
                }
                else{
                    student.setSelected(true);
                }
                students.set(position,student);
                adapter.updateBook(students);
            }
        });
    }

    private List<Student> initData(){
        Student student_1 = new Student("Иван","Пупкин","муж","ПП-2709");
        Student student_2 = new Student("Женя","Добролюбов","муж","ПП-2709");
        Student student_3 = new Student("Людмила","Иванова","жен","ПП-2503");

        List<Student> students=new ArrayList<>();
        students.add(student_1);
        students.add(student_2);
        students.add(student_3);

        return  students;
    }

    public void btnDeleteClick(View view) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).isSelected()){
                students.remove(students.get(i));
                i--;
            }
        }
        adapter.updateBook(students);
    }

    static final private int ADD_STUDENT = 0;
    public void btnAdd_click(View view) {
        Intent questionIntent = new Intent(MainActivity.this,
                AddStudent_Activity.class);
        startActivityForResult(questionIntent, ADD_STUDENT);
    }

}
