package org.coolstyles.baitap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.coolstyles.baitap.R;
import org.coolstyles.baitap.Student;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context; // biến môi trường
    private List<Student> list;

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Student> students) {
        this.list = students;
    }

    // ánh xạ layout cho mỗi item trong danh sách recycle view
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    // truyền dữ liệu vào GUI
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = list.get(position);

        if (student == null) {
            return;
        }

        holder.name.setText(student.getName());
    }

    // lấy ra số phần tử đang tồn tại trong mảng
    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }

        return 0;
    }


    // ánh xạ widget bên layout item

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_nameStd);
        }
    }
}