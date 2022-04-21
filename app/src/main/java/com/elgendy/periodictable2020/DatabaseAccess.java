package com.elgendy.periodictable2020;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if (db != null){
            this.db.close();
        }
    }

    public String getEnglishName(String name){
        c = db.rawQuery("select EnglishName from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getLatinName(String name){
        c = db.rawQuery("select LatinName from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getYear(String name){
        c = db.rawQuery("select YearOfDiscovery from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getDiscoverer(String name){
        c = db.rawQuery("select Discoverer from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getCasNumber(String name){
        c = db.rawQuery("select CasNumber from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getAtomicNumber(String name){
        c = db.rawQuery("select AtomicNumber from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getPeriodGroup(String name){
        c = db.rawQuery("select PeriodGroup from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getBlocks(String name){
        c = db.rawQuery("select Block from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElementCategory(String name){
        c = db.rawQuery("select ElementCategory from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getNumberOfProtons(String name){
        c = db.rawQuery("select NumberOfProtons from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getNumberOfElectrons(String name){
        c = db.rawQuery("select NumberOfElectrons from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getNumberOfNeutrons(String name){
        c = db.rawQuery("select NumberOfNeutrons from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getAtomicWeight(String name){
        c = db.rawQuery("select AtomicWeight from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectronicConfiguration(String name){
        c = db.rawQuery("select ElectronicConfiguration from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectronShell(String name){
        c = db.rawQuery("select ElectronShell from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getIonCharge(String name){
        c = db.rawQuery("select IonCharge from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getIonizationPotential(String name){
        c = db.rawQuery("select IonizationPotential from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getOxidationState(String name){
        c = db.rawQuery("select OxidationState from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getAtomicRadius(String name){
        c = db.rawQuery("select AtomicRadius from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getCovalentRadius(String name){
        c = db.rawQuery("select CovalentRadius from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getVanDerWaalsRadius(String name){
        c = db.rawQuery("select VanDerWaalsRadius from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getDensity(String name){
        c = db.rawQuery("select Density from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getPhysicalState(String name){
        c = db.rawQuery("select PhysicalState from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getColor(String name){
        c = db.rawQuery("select Color from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getMeltingPoint(String name){
        c = db.rawQuery("select MeltingPoint from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getBoilingPoint(String name){
        c = db.rawQuery("select BoilingPoint from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectronegativity(String name){
        c = db.rawQuery("select Electronegativity from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getValence(String name){
        c = db.rawQuery("select Valence from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectronAffinity(String name){
        c = db.rawQuery("select ElectronAffinity from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getFusionHeat(String name){
        c = db.rawQuery("select FusionHeat from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getSpecificHeat(String name){
        c = db.rawQuery("select SpecificHeat from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getVaporizationHeat(String name){
        c = db.rawQuery("select VaporizationHeat from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectricalConductivity(String name){
        c = db.rawQuery("select ElectricalConductivity from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getElectricalType(String name){
        c = db.rawQuery("select ElectricalType from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getMagneticType(String name){
        c = db.rawQuery("select MagneticType from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getMolarMagneticSusceptibility(String name){
        c = db.rawQuery("select MolarMagneticSusceptibility from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getMassMagneticSusceptibility(String name){
        c = db.rawQuery("select MassMagneticSusceptibility from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getVolumeMagneticSusceptibility(String name){
        c = db.rawQuery("select VolumeMagneticSusceptibility from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getResistivity(String name){
        c = db.rawQuery("select Resistivity from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInUniverse(String name){
        c = db.rawQuery("select InUniverse from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInSun(String name){
        c = db.rawQuery("select InSun from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInMeteorites(String name){
        c = db.rawQuery("select InMeteorites from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInEarthCrust(String name){
        c = db.rawQuery("select InEarthCrust from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInOceans(String name){
        c = db.rawQuery("select InOceans from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getInHumanBody(String name){
        c = db.rawQuery("select InHumanBody from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getRadioActive(String name){
        c = db.rawQuery("select RadioActive from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getHalfLifeTime(String name){
        c = db.rawQuery("select HalfLifeTime from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getDecayMode(String name){
        c = db.rawQuery("select DecayMode from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getUsesAndImportance(String name){
        c = db.rawQuery("select UsesAndImportance from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getUsesAndImportance2(String name){
        c = db.rawQuery("select UsesAndImportance2 from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getUsesAndImportance3(String name){
        c = db.rawQuery("select UsesAndImportance3 from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }
    public String getLinks (String name){
        c = db.rawQuery("select Links from TableElements where EnglishName = '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String string =  c.getString(0);
            buffer.append("" + string);
        }
        return buffer.toString();
    }

}