package com.example.eric.android_attack;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by eric on 2018/4/10.
 */

public class Privilege {

    private static Process process = null;

    public static boolean visitRuntime(String... cmds)
    {
        if (cmds == null || cmds.length == 0) {
            return false;
        }

        DataOutputStream dos = null;
        InputStream dis = null;
        try
        {

            process = Runtime.getRuntime().exec("su");

            dos = new DataOutputStream(process.getOutputStream());

            for (int i = 0; i < cmds.length; i++) {
                dos.writeBytes(cmds[i] + " \n");
            }
            dos.writeBytes("exit \n");

            int code = process.waitFor();

            return code == 0;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (process != null) {
                    process.destroy();
                    process = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }
}
