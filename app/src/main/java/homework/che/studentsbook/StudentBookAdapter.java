package homework.che.studentsbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentBookAdapter extends BaseAdapter {
    private Activity activity;
    private List<Student> students;
    private LayoutInflater layoutInflater;

    public StudentBookAdapter(Activity activity, List<Student> students) {
        this.activity = activity;
        this.students = students;

        layoutInflater=activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return students.size();
}

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_layout, parent, false);

            holder = new ViewHolder();

            holder.avatar_IV = view.findViewById(R.id.imageView_male);
            holder.firstName_TV = view.findViewById(R.id.textView_firstName);
            holder.lastName_TV = view.findViewById(R.id.textView_LastName);
            holder.group_TV = view.findViewById(R.id.textView_group);
            holder.checkBox_IV=view.findViewById(R.id.checkBox_IV);

            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)view.getTag();
        }

        Student student=students.get(position);

        //заполняем вью
        if(student.getMale()=="муж"||student.getMale()=="male"){
            holder.avatar_IV.setImageResource(R.drawable.male);
        }
        else if((student.getMale()=="жен"||student.getMale()=="famale")){
            holder.avatar_IV.setImageResource(R.drawable.famale);
        }
        else{
            holder.avatar_IV.setImageResource(R.drawable.famale);
        }
        holder.firstName_TV.setText(student.getFirstName());
        holder.lastName_TV.setText(student.getLastName());
        holder.group_TV.setText(student.getGroup());

        if(student.isSelected()){
            holder.checkBox_IV.setImageResource(R.drawable.checked);
        }
        else {
            holder.checkBox_IV.setImageResource(R.drawable.checky);
        }
        return view;
    }
    class ViewHolder{
        TextView firstName_TV;
        TextView lastName_TV;
        TextView group_TV;
        ImageView avatar_IV;
        ImageView checkBox_IV;
    }

    private Student getStudent(int position){
        return (Student)getItem(position);
    }
    public void updateBook(List<Student> students){
        this.students=students;
        notifyDataSetChanged();
    }

}

