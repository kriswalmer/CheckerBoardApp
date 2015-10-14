package edu.temple.tue80717.checkerboardapp;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CheckerBoard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CheckerBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckerBoard extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int numberRows = 0;
    boolean isBlack;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckerBoard.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckerBoard newInstance(String param1, String param2) {
        CheckerBoard fragment = new CheckerBoard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CheckerBoard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View theView =  inflater.inflate(R.layout.fragment_checker_board, container, false);


        Bundle b = getArguments();


        ArrayList<Item> gridArray = new ArrayList<Item>();
        RowAdapter customGridAdapter;

        try{
            numberRows = b.getInt("num_rows");
        } catch(Exception e){
            numberRows = 0;
        };

        try{
            numberRows = b.getInt("num_rows");
        } catch(Exception e){
            numberRows = 0;
        };

        final GridView gridView = (GridView) theView.findViewById(R.id.gridView);
        gridView.setNumColumns(numberRows);

         int cell = 1 ;

        for(int i = 1; i <= numberRows; i++){
            isBlack = !isBlack;
            for(int j = 1; j <= numberRows; j++, cell++) {
                gridArray.add(new Item((cell), isBlack));
                isBlack = !isBlack;
            }
        }
         Resources res = getResources();
        customGridAdapter = new RowAdapter(getActivity(), R.layout.fragment_checker_board, gridArray, res);

        gridView.setAdapter(customGridAdapter);
/*8
        GridView gridView2 =  (GridView) theView.findViewById(R.id.gridView);
        ArrayList<TextView> display = new ArrayList<TextView>();
        ArrayAdapter<TextView> adapter;
        adapter = new ArrayAdapter<TextView>(getActivity(),
                android.R.layout.simple_list_item_1, display);

       // TextView tv1 = new (TextView) theView.findViewById(tv1) ;
        //adapter.insert();

     /*   final int N = 10; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(getActivity());

            // set some properties of rowTextView or something
            rowTextView.setText("This is row #" + i);

            // add the textview to the linearlayout
           // R.id.myframelayout addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }






        gridView.setAdapter(adapter);*/

        return theView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
