package com.sven.rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sven.rx.model.StudentBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_content)
    TextView tvContent;
    private ArrayList<StudentBean> studentBeenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        studentBeenList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentBean studentBean = new StudentBean();
            studentBean.setName("姓名" + i);
            ArrayList<StudentBean.Course> Courses = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                StudentBean.Course Course = studentBean.new Course();
                Course.setName("学科" + j);
                Course.setMark("分数" + j);
                Courses.add(Course);
                studentBean.setCourses(Courses);
            }
            studentBeenList.add(studentBean);
        }
    }

    private void flatmap() {
        Observable.from(studentBeenList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<StudentBean, Observable<StudentBean.Course>>() {
                    @Override
                    public Observable<StudentBean.Course> call(StudentBean studentBean) {
                        return Observable.from(studentBean.getCourses());
                    }
                })
                .subscribe(new Action1<StudentBean.Course>() {
                    @Override
                    public void call(StudentBean.Course course) {
                        tvContent.append(course.getName() + "_" + course.getMark() + "end----------");
                    }
                });
    }

    private void map(ArrayList<StudentBean> studentBeenList) {
        Observable.from(studentBeenList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<StudentBean, String>() {
                    @Override
                    public String call(StudentBean studentBean) {
                        return studentBean.getName();
                    }
                })
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        tvContent.append(s + ",");
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);*/
        super.onCreateOptionsMenu(menu);
        for (int i = 0; i < 10; i++) {
            menu.add(Menu.NONE, Menu.FIRST + i, 0, i + "").setIcon(R.mipmap.ic_launcher);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case Menu.FIRST:
                map(studentBeenList);//打印每个学生的姓名
                break;
            case Menu.FIRST + 1:
                flatmap();//打印每个学生的学科
                break;
            case Menu.FIRST + 2:
                Toast.makeText(this, Menu.FIRST + "2", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 3:
                Toast.makeText(this, Menu.FIRST + "3", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 4:
                Toast.makeText(this, Menu.FIRST + "4", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 5:
                Toast.makeText(this, Menu.FIRST + "5", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 6:
                Toast.makeText(this, Menu.FIRST + "6", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 7:
                Toast.makeText(this, Menu.FIRST + "7", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 8:
                Toast.makeText(this, Menu.FIRST + "8", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 9:
                Toast.makeText(this, Menu.FIRST + "9", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
