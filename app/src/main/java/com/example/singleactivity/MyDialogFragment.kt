import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.singleactivity.R
import com.example.singleactivity.SingleActivity

class MyDialogFragment: DialogFragment() {
    private val TAG = "MyDialogFragment a85l"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG, "onCreateDialog: ")
        return AlertDialog.Builder(activity!!).setTitle("神灯")
                .setMessage("来选择你要实现的一个愿望")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("车子"){ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(context,"你选了车子",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("房子"){ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(context,"你选了房子",Toast.LENGTH_SHORT).show()
                }
                .create()
    }

    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach: ")
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: ")
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach: ")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
    }
}