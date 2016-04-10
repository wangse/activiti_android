package rendezvous.activiti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListResultsFragment listResultsFragment = new ListResultsFragment();
    private ProfileViewFragment profileViewFragment = new ProfileViewFragment();
    private EditProfileFragment editProfileFragment = new EditProfileFragment();
    private ActivitiViewFragment activitiViewFragment = new ActivitiViewFragment();
    private AllActivitiFragment allActivitiFragment = new AllActivitiFragment();
    private CreateActivitiFragment createActivitiFragment = new CreateActivitiFragment();
    private FindActivitiFragment findActivitiFragment = new FindActivitiFragment();
    private FriendProfileViewFragment friendProfileViewFragment = new FriendProfileViewFragment();
    private BadgeViewFragment badgeViewFragment = new BadgeViewFragment();
    private LeaveBadgeFragment leaveBadgeFragment = new LeaveBadgeFragment();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_menu);
        ProfileViewFragment profileViewFragment = new ProfileViewFragment();
        navigate(profileViewFragment);

    }

    @Override
    public void onBackPressed(){
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 1){
            super.onBackPressed();
            //additional code
        }

        else{
            getFragmentManager().popBackStack();
            Toast toast = Toast.makeText(MyApplication.getAppContext(), "Back works!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void navigate(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void searchActivities(View view) {
        navigate(listResultsFragment);
        //Code to send search query to server
    }

    public void viewOtherProfile(View view) {
        navigate(friendProfileViewFragment);
    } 

    public void viewProfile(View view) {
        navigate(profileViewFragment);
    }

    public void editProfile(View view) {
        navigate(editProfileFragment);
    }

    public void viewActiviti(View view) {
        navigate(activitiViewFragment);
    }

    public void saveProfile(View view) {
        viewProfile(view);
        //Code for sending updated data to server
    }

    public void seeAllActivitis(View view) {
        navigate(allActivitiFragment);
    }

    public void submitNewActiviti(View view) {
        //Code for sending new activiti data to server
        viewProfile(view);
    }

    public void createActiviti(View view) {
        navigate(createActivitiFragment);
    }

    public void findActiviti(View view) {
        navigate(findActivitiFragment);
    }

    public void badgeView(View view){
        navigate(badgeViewFragment);
    }

    public void viewAllActivities(View view) {
        navigate(allActivitiFragment);
    }

    public void leaveBadge(View view){
        navigate(leaveBadgeFragment);
    }

    public boolean isValidDate(){
        Calendar c = Calendar.getInstance();
        int month = 0, day = 0, year = 0;

        //check month
        if(month < 1 || month > 12){
            return false;
        }

        //check leap year days
        if(month==2){
            if(year % 4 == 0){
                if(day > 29)
                    return false;
            }

            else
                if(day > 28)
                    return false;
        }

        else if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day > 30)
                return false;
        }

        else{
            if(day > 31)
                return false;
        }

        if(day < 1)
            return false;

        if(year < c.YEAR || year > (c.YEAR + 10)){
            return false;
        }

        return true;
    }
}