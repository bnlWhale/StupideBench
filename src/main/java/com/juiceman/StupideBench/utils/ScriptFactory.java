package com.juiceman.StupideBench.utils;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class ScriptFactory {

    private Map<String, String> scriptMap = new HashMap();
    private final String dirOfScript = "javascript/";
    private static  ScriptFactory instance;

    private ScriptFactory(){

    }

    public static  ScriptFactory getInstance(){

        if(instance == null){
            instance = new ScriptFactory();
        }
        return instance;
    }



    public String getScriptStrByName(String scriptName){


        ClassLoader classLoader = getClass().getClassLoader();
        String findPath = classLoader.getResource(dirOfScript+scriptName).getPath().toString();

        Path path = Paths.get(findPath);
        if(scriptMap.containsKey(scriptName)){
            return scriptMap.get(scriptName);
        }


        try {
            final String script = "function() {\n" +
                    new String(Files.readAllBytes(path), Charset.forName("UTF-8")) + "\n" +
                    "}\n";
            scriptMap.put(scriptName,  script);
            System.out.println("javascript file's path:"+findPath);
            return script;
        }
        catch(NoSuchFileException e){
            scriptMap.put(scriptName, null);
            System.out.println(e);
        }
        catch (IOException e)
        {
            scriptMap.put(scriptName, null);
            e.printStackTrace();
        }

        return null;

    }


}

