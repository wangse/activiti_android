package rendezvous.activiti;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActivitiViewFragment extends Fragment {
    //A subclass of Fragment, ActivitiVCiewFragment is used when an activiti is clicked on for more information
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_activiti_view, container, false);
        return view;
    }

}
