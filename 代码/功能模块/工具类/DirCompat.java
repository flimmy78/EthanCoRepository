package cn.nbhope.smarthome.utils.compat;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Description 路径的兼容
 * Created by Zhk on 2015/12/24.
 */
public class DirCompat {
    public static final String FOLDER_DOWNLOAD = "download";

    public static String getCacheDir(Context context) {
        String path;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (null == context.getExternalCacheDir()) {
                path = Environment.getExternalStorageDirectory().getPath();
            } else {
                path = context.getExternalCacheDir().getPath();
            }
        } else {
            path = context.getCacheDir().getPath();
        }
        return path;
    }

    public static String getFileDir(Context context) {
        return getFileDir(context, null);
    }

    private static String getFileDir(Context context, String folder) {
        String path;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            path = context.getExternalFilesDir(folder).getPath();
        } else {
            path = context.getFilesDir().getPath() + File.separator + folder;
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return path;
    }

    public static String getDownloadDir(Context context) {
        return getFileDir(context, FOLDER_DOWNLOAD);
    }
}
