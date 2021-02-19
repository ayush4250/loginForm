package com.example.myapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.PersonDetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.personModel;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<personModel> personModelList;

    public PersonAdapter(List<personModel> personModelList) {
        this.personModelList = personModelList;

    }
        @NonNull
        @Override
        public PersonAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder (@NonNull PersonAdapter.ViewHolder holder,int position){
            String name = personModelList.get(position).getName();
            String email = personModelList.get(position).getEmail();
            String phone = personModelList.get(position).getPhone();
            String gender = personModelList.get(position).getGender();
            String personId = personModelList.get(position).getPersonId();


            holder.setData(name, email, phone, gender,personId);
        }

        @Override
        public int getItemCount () {
           return personModelList.size();
        }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, email, phone, gender;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.editname);
            email = itemView.findViewById(R.id.editemail);
            phone = itemView.findViewById(R.id.editphone);
            gender = itemView.findViewById(R.id.editgender);


        }

        private void setData(final String name1, String mail1, String phone1, String gender1, final String personid) {

            name.setText(name1);
            email.setText(mail1);
            phone.setText(phone1);
            gender.setText(gender1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(), PersonDetailActivity.class);
                    intent.putExtra("personId",personid);
                    itemView.getContext().startActivity(intent);

                }
            });


        }


    }


}
