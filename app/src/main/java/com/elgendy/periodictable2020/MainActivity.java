package com.elgendy.periodictable2020;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

import com.elgendy.periodictable2020.Dictionary.DictionaryActivity;
import com.elgendy.periodictable2020.Search.SearchActivity;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SharedPref sharedpref;
    TextView all,non_metals,alkali_metals,alkaline_earth,metalloids,main_transition,post_transition,halogens,noble_gases,lantanoides,actinoides,
            name_view,atomic_weight_view,cas_view,category_view,electron_view;
    LinearLayout hydrogen,carbon,nitrogen,oxygen,phosphorus,sulfur,selenium,lithium,sodium,potassium,rubidium,cesium,francium,beryllium,magnesium,calcium,strontium,barium,radium,helium,neon,argon,krypton,xenon,radon,oganesson,fluorine,chlorine,bromine,iodine,astatine,tennessine,b2,actinium,thorium,uranium,mendelevium,proactinium,neptonium,americium,curium,berkelium,californium,einsteinium,fermium,nobelium,lawrencium,plutonium,boron,silicon,germanium,arsenic,antimony,tellurium,polonium,aluminium,gallium,indium,tin,thallium,lead,bismuth,nihonium,flerovium,moscovium,livermorium,scandmium,titanium,vanadium,manganese,iron,cobalt,nickel,chromium,zinc,copper,yttrium,zirconium,niobium,molybdenum,technetium,ruthenium,rhodium,palladium,silver,cadmium,hafnium,tanlatum,tungesten,rhenium,osmium,iridium,platinum,gold,mercury,rutherfordium,dubnium,seaborgium,bhorium,hassium,meintnerium,darmstadium,roentgenium,copernicium,b1,lanthanum,cerium,praseodymium,neodymium,promethium,samarium,europium,gadolinium,terbium,dysprosium,holmium,erbium,thulium,ytterbium,lutetium;
    ImageView imageView, imageView2, close;
    Button  btn_rate;
    private int totalCount = 0;
    private String link = "https://appgallery.huawei.com/#/app/C103535775?locale=en_US&source=appshare&subsource=C103535775&fbclid=IwAR0KrxURQL2rnwIlZUC8OGZBQAqv8eh-zITan68jJ7TGpcxgfkR-AG0-plU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()) {
            setTheme(R.style.DarkTheme);
        }
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        all=findViewById(R.id.txt_all);
        //NON METALS
        non_metals = findViewById(R.id.txt_non_metals); hydrogen = findViewById(R.id.btn_H);carbon = findViewById(R.id.btn_carbon);nitrogen=findViewById(R.id.btn_nitrogen);oxygen=findViewById(R.id.btn_oxygen);phosphorus=findViewById(R.id.btn_phosphorus);sulfur=findViewById(R.id.btn_sulfur);selenium=findViewById(R.id.btn_selenium);
        //ALKALI METALS
        alkali_metals=findViewById(R.id.txt_alkali_metals);lithium=findViewById(R.id.btn_lithium);sodium=findViewById(R.id.btn_sodium);potassium=findViewById(R.id.btn_potassium);rubidium=findViewById(R.id.btn_rubidium);cesium=findViewById(R.id.btn_cesium);francium=findViewById(R.id.btn_francium);
        //ALKALINE EARTH METALS
        alkaline_earth=findViewById(R.id.txt_alkaline_earth_metals);beryllium=findViewById(R.id.btn_beryllium);magnesium=findViewById(R.id.btn_magnesium);calcium=findViewById(R.id.btn_calcium);strontium=findViewById(R.id.btn_strontium);barium=findViewById(R.id.btn_barium);radium=findViewById(R.id.btn_radium);
        //NOBLE GASES
        noble_gases=findViewById(R.id.txt_noble_gases);helium=findViewById(R.id.btn_helium);neon=findViewById(R.id.btn_neon);argon=findViewById(R.id.btn_argon);krypton=findViewById(R.id.btn_krypton);xenon=findViewById(R.id.btn_xenon);radon=findViewById(R.id.btn_radon);oganesson=findViewById(R.id.btn_oganesson);
        //HALOGENS
        halogens=findViewById(R.id.txt_halogens);fluorine=findViewById(R.id.btn_fluorine);chlorine=findViewById(R.id.btn_chlorine);bromine=findViewById(R.id.btn_bromine);iodine=findViewById(R.id.btn_iodine);astatine=findViewById(R.id.btn_astatine);tennessine=findViewById(R.id.btn_tennessine);
        //METALLOIDS
        metalloids=findViewById(R.id.txt_metalloids);boron=findViewById(R.id.btn_boron);silicon=findViewById(R.id.btn_silicon);germanium=findViewById(R.id.btn_germanium);arsenic=findViewById(R.id.btn_arsenic);antimony=findViewById(R.id.btn_antimony);tellurium=findViewById(R.id.btn_tellurium);polonium=findViewById(R.id.btn_polonium);
        //POST TRANSITION METALS
        post_transition=findViewById(R.id.txt_post_transition);aluminium=findViewById(R.id.btn_aluminium);gallium=findViewById(R.id.btn_gallium);indium=findViewById(R.id.btn_indium);tin=findViewById(R.id.btn_tin);thallium=findViewById(R.id.btn_thallium);lead=findViewById(R.id.btn_lead);bismuth=findViewById(R.id.btn_bismuth);nihonium=findViewById(R.id.btn_nihonium);flerovium=findViewById(R.id.btn_flerovium);moscovium=findViewById(R.id.btn_moscovium);livermorium=findViewById(R.id.btn_livermorium);
        //MAIN TRANSITION METALS
        main_transition=findViewById(R.id.txt_main_transition);scandmium=findViewById(R.id.btn_scandium);titanium=findViewById(R.id.btn_titanium);vanadium=findViewById(R.id.btn_vanadium);chromium=findViewById(R.id.btn_chromium);manganese=findViewById(R.id.btn_manganese);iron=findViewById(R.id.btn_iron);cobalt=findViewById(R.id.btn_cobalt);nickel=findViewById(R.id.btn_nickel);copper=findViewById(R.id.btn_copper);zinc=findViewById(R.id.btn_zinc);yttrium=findViewById(R.id.btn_yttrium);zirconium=findViewById(R.id.btn_zirconium);niobium=findViewById(R.id.btn_niobium);molybdenum=findViewById(R.id.btn_molybdenum);technetium=findViewById(R.id.btn_technetium);ruthenium=findViewById(R.id.btn_ruthenium);palladium=findViewById(R.id.btn_palladium);rhodium=findViewById(R.id.btn_rhodium);silver=findViewById(R.id.btn_silver);cadmium=findViewById(R.id.btn_cadmium);hafnium=findViewById(R.id.btn_hafnium);tanlatum=findViewById(R.id.btn_tantalum);tungesten=findViewById(R.id.btn_tungsten);rhenium=findViewById(R.id.btn_rhenium);osmium=findViewById(R.id.btn_osmium);iridium=findViewById(R.id.btn_iridium);platinum=findViewById(R.id.btn_platinum);gold=findViewById(R.id.btn_gold);mercury=findViewById(R.id.btn_mercury);rutherfordium=findViewById(R.id.btn_rutherfordium);dubnium=findViewById(R.id.btn_dubnium);seaborgium=findViewById(R.id.btn_seaborgium);bhorium=findViewById(R.id.btn_bohrium);hassium=findViewById(R.id.btn_hassium);meintnerium=findViewById(R.id.btn_meitnerium);darmstadium=findViewById(R.id.btn_darmstadtium);roentgenium=findViewById(R.id.btn_roentgenium);copernicium=findViewById(R.id.btn_copernicium);
        //LANTHANOIDS
        lantanoides=findViewById(R.id.txt_lanthanoides);b1=findViewById(R.id.btn_1);lanthanum=findViewById(R.id.btn_lanthanum);cerium=findViewById(R.id.btn_cerium);praseodymium=findViewById(R.id.btn_praseodymiumm);neodymium=findViewById(R.id.btn_neodymium);promethium=findViewById(R.id.btn_promethium);samarium=findViewById(R.id.btn_samarium);europium=findViewById(R.id.btn_europium);gadolinium=findViewById(R.id.btn_gadolinium);terbium=findViewById(R.id.btn_terbium);dysprosium=findViewById(R.id.btn_dysprosium);holmium=findViewById(R.id.btn_holmium);erbium=findViewById(R.id.btn_erbium);thulium=findViewById(R.id.btn_thulium);ytterbium=findViewById(R.id.btn_ytterbium);lutetium=findViewById(R.id.btn_lutetium);
        //ACTINOIDES
        actinoides=findViewById(R.id.txt_actinoides);b2=findViewById(R.id.btn_2);actinium=findViewById(R.id.btn_actinium);thorium=findViewById(R.id.btn_thorium);uranium=findViewById(R.id.btn_uranium);mendelevium=findViewById(R.id.btn_mendelevium);proactinium=findViewById(R.id.btn_protactinium);neptonium=findViewById(R.id.btn_neptunium);americium=findViewById(R.id.btn_americium);curium=findViewById(R.id.btn_curium);berkelium=findViewById(R.id.btn_berkelium);californium=findViewById(R.id.btn_californium);einsteinium=findViewById(R.id.btn_einsteinium);fermium=findViewById(R.id.btn_fermium);nobelium=findViewById(R.id.btn_nobelium);lawrencium=findViewById(R.id.btn_lawrencium);plutonium=findViewById(R.id.btn_plutonium);

        SharedPreferences visits = this.getSharedPreferences("visits", Context.MODE_PRIVATE);
        totalCount = visits.getInt("open", 0);


        hydrogen.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Hydrogen",R.drawable.hydrogen_diagram,R.drawable.hydrogen_photo);
                return true;
            }
        });
        helium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Helium",R.drawable.helium_diagram,R.drawable.helium_photo);
                return true;
            }
        });
        lithium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Lithium",R.drawable.lithium_diagram,R.drawable.lithium_photo);
                return true;
            }
        });
        beryllium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Beryllium",R.drawable.beryllium_diagram,R.drawable.beryllium_photo);
                return true;
            }
        });
        boron.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Boron",R.drawable.boron_diagram,R.drawable.boron_photo);
                return true;
            }
        });
        carbon.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Carbon",R.drawable.carbon_diagram,R.drawable.carbon_photo);
                return true;
            }
        });
        nitrogen.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Nitrogen",R.drawable.nitrogen_diagram,R.drawable.nitrogen_photo);
                return true;
            }
        });
        oxygen.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Oxygen",R.drawable.oxygen_diagram,R.drawable.oxygen_photo);
                return true;
            }
        });
        fluorine.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Fluorine",R.drawable.fluorine_diagram,R.drawable.fluorine_photo);
                return true;
            }
        });
        neon.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Neon",R.drawable.neon_diagram,R.drawable.neon_photo);
                return true;
            }
        });
        sodium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Sodium",R.drawable.sodium_diagram,R.drawable.sodium_photo);
                return true;
            }
        });
        magnesium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Magnesium",R.drawable.magnesium_diagram,R.drawable.magnesium_photo);
                return true;
            }
        });
        aluminium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Aluminum",R.drawable.aluminum_diagram,R.drawable.aluminium_photo);
                return true;
            }
        });
        silicon.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Silicon",R.drawable.silicon_diagram,R.drawable.silicon_photo);
                return true;
            }
        });
        phosphorus.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Phosphorus",R.drawable.phosphorus_diagram,R.drawable.phosphorus_photo);
                return true;
            }
        });
        sulfur.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Sulfur",R.drawable.sulfur_diagram,R.drawable.sulfur_photo);
                return true;
            }
        });
        chlorine.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Chlorine",R.drawable.chlorine_diagram,R.drawable.chlorine_photo);
                return true;
            }
        });
        argon.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Argon",R.drawable.argon_diagrampng,R.drawable.argon_photo);
                return true;
            }
        });
        potassium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Potassium",R.drawable.potassium_diagram,R.drawable.potassium_photo);
                return true;
            }
        });
        calcium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Calcium",R.drawable.calcium_diagram,R.drawable.calcium_photo);
                return true;
            }
        });
        scandmium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Scandium",R.drawable.scandium_diagram,R.drawable.scandium_photo);
                return true;
            }
        });
        titanium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Titanium",R.drawable.titanium_diagram,R.drawable.titanium_photo);
                return true;
            }
        });
        vanadium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Vanadium",R.drawable.vanadium_diagram,R.drawable.vanadium_photo);
                return true;
            }
        });
        chromium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Chromium",R.drawable.chromium_diagram,R.drawable.chromium_photo);
                return true;
            }
        });
        manganese.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Manganese",R.drawable.manganese_diagram,R.drawable.manganese_photo);
                return true;
            }
        });
        iron.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Iron",R.drawable.iron_diagram,R.drawable.iron_photo);
                return true;
            }
        });
        cobalt.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Cobalt",R.drawable.cobalt_diagram,R.drawable.cobalt_photo);
                return true;
            }
        });
        nickel.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Nickel",R.drawable.nickel_diagram,R.drawable.nickel_photo);
                return true;
            }
        });
        copper.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Copper",R.drawable.copper_diagram,R.drawable.copper_photo);
                return true;
            }
        });
        zinc.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Zinc",R.drawable.zinc_diagram,R.drawable.zinc_photo);
                return true;
            }
        });
        gallium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Gallium",R.drawable.gallium_diagram,R.drawable.gallium_photo);
                return true;
            }
        });
        germanium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Germanium",R.drawable.germanium_diagram,R.drawable.germanium_photo);
                return true;
            }
        });
        arsenic.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Arsenic",R.drawable.arsenic_diagram,R.drawable.arsenic_photo);
                return true;
            }
        });
        selenium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Selenium",R.drawable.bromine_diagram,R.drawable.bromine_photo);
                return true;
            }
        });
        bromine.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Bromine",R.drawable.bromine_diagram,R.drawable.bromine_photo);
                return true;
            }
        });
        krypton.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Krypton",R.drawable.krypton_diagram,R.drawable.krypton_photo);
                return true;
            }
        });
        rubidium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Rubidium",R.drawable.rubidium_diagram,R.drawable.rubidium_photo);
                return true;
            }
        });
        strontium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Strontium",R.drawable.strontium_diagram,R.drawable.strontium_photo);
                return true;
            }
        });
        yttrium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Ytrrium",R.drawable.yttrium_diagram,R.drawable.yttrium_photo);
                return true;
            }
        });
        zirconium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Zirconium",R.drawable.zirconium_diagram,R.drawable.zirconium_photo);
                return true;
            }
        });
        niobium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Niobium",R.drawable.niobium_diagram,R.drawable.niobium_photo);
                return true;
            }
        });
        molybdenum.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Molybdenum",R.drawable.molybdenum_diagram,R.drawable.molybdenum_phot);
                return true;
            }
        });
        technetium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Technetium",R.drawable.technetium_diagram,R.drawable.technetium_photo);
                return true;
            }
        });
        ruthenium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Ruthenium",R.drawable.ruthenium_diagram,R.drawable.ruthenium_photo);
                return true;
            }
        });
        rhodium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Rhodium",R.drawable.rhodium_diagram,R.drawable.rhodium_photo);
                return true;
            }
        });
        palladium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Palladium",R.drawable.palladium_diagram,R.drawable.palladium_photo);
                return true;
            }
        });
        silver.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Silver",R.drawable.silver_diagram,R.drawable.silver_photo);
                return true;
            }
        });
        cadmium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Cadmium",R.drawable.cadmium_diagram,R.drawable.cadmium_photo);
                return true;
            }
        });
        indium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Indium",R.drawable.indium_diagram,R.drawable.indium_photo);
                return true;
            }
        });
        tin.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Tin",R.drawable.tin_diagram,R.drawable.tin_photo);
                return true;
            }
        });
        antimony.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Antimony",R.drawable.antimony_diagram,R.drawable.antimony_photo);
                return true;
            }
        });
        tellurium.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Tellurium",R.drawable.tellurium_diagram,R.drawable.tellurium_photo);
                return true;
            }
        });
        iodine.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Iodine",R.drawable.iodine_diagram,R.drawable.iodine_photo);
                return true;
            }
        });
        xenon.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                GetLongData("Xenon",R.drawable.xenon_diagram,R.drawable.xenon_photo);
                return true;
            }
        });
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        totalCount += 1;
        SharedPreferences visits = getSharedPreferences("visits", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = visits.edit();
        editor.putInt("open", totalCount);
        editor.commit();

        if (totalCount == 30){
            AlertDialog.Builder rateDialog = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.rating_deign, null);
            rateDialog.setView(view);
            final AlertDialog alert = rateDialog.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.show();
            alert.setCancelable(false);
            btn_rate = view.findViewById(R.id.btn_rate);
            close = view.findViewById(R.id.close);


            btn_rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editor.commit();
                    alert.cancel();
                    Uri uri = Uri.parse(link);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    totalCount = 0;
                    editor.commit();
                    alert.cancel();
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if (id == R.id.search){
            Intent search=new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(search);
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.setting_app) {
            Intent set = new Intent(getApplicationContext(),SettingActivity.class);
            startActivity(set);
        }
        else if (id == R.id.def_of_terms_app) {
            Intent def=new Intent(getApplicationContext(), DictionaryActivity.class);
            startActivity(def);
        }
        else if (id == R.id.about_app) {
            Intent about=new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(about);
        }
        else if (id == R.id.share_app) {
            String copy = "Download Periodic Table 2021 now for free. \n" + link;
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text ", copy);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getApplicationContext(),"Link copied to clipboard",Toast.LENGTH_LONG).show();

        }
        else if (id == R.id.rate_app){
            Uri uri = Uri.parse(link);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.exit_app){
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void OnAlkaliMetals(View view) {
        lithium.setBackgroundResource(R.drawable.alkali_metals);
        sodium.setBackgroundResource(R.drawable.alkali_metals);
        potassium.setBackgroundResource(R.drawable.alkali_metals);
        rubidium.setBackgroundResource(R.drawable.alkali_metals);
        cesium.setBackgroundResource(R.drawable.alkali_metals);
        francium.setBackgroundResource(R.drawable.alkali_metals);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);
    }

    public void OnAlkalineMetals(View view) {
        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        magnesium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        calcium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        barium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        radium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        strontium.setBackgroundResource(R.drawable.alkaline_earth_metals);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);

    }

    public void OnMainTransition(View view) {
        //MAIN TRANSITION METALS
        titanium.setBackgroundResource(R.drawable.transition_metals);
        vanadium.setBackgroundResource(R.drawable.transition_metals);
        chromium.setBackgroundResource(R.drawable.transition_metals);
        manganese.setBackgroundResource(R.drawable.transition_metals);
        iron.setBackgroundResource(R.drawable.transition_metals);
        scandmium.setBackgroundResource(R.drawable.transition_metals);
        cobalt.setBackgroundResource(R.drawable.transition_metals);
        nickel.setBackgroundResource(R.drawable.transition_metals);
        chromium.setBackgroundResource(R.drawable.transition_metals);
        zinc.setBackgroundResource(R.drawable.transition_metals);
        copper.setBackgroundResource(R.drawable.transition_metals);
        yttrium.setBackgroundResource(R.drawable.transition_metals);
        zirconium.setBackgroundResource(R.drawable.transition_metals);
        niobium.setBackgroundResource(R.drawable.transition_metals);
        molybdenum.setBackgroundResource(R.drawable.transition_metals);
        technetium.setBackgroundResource(R.drawable.transition_metals);
        ruthenium.setBackgroundResource(R.drawable.transition_metals);
        rhodium.setBackgroundResource(R.drawable.transition_metals);
        palladium.setBackgroundResource(R.drawable.transition_metals);
        silver.setBackgroundResource(R.drawable.transition_metals);
        cadmium.setBackgroundResource(R.drawable.transition_metals);
        hafnium.setBackgroundResource(R.drawable.transition_metals);
        tanlatum.setBackgroundResource(R.drawable.transition_metals);
        tungesten.setBackgroundResource(R.drawable.transition_metals);
        rhenium.setBackgroundResource(R.drawable.transition_metals);
        osmium.setBackgroundResource(R.drawable.transition_metals);
        iridium.setBackgroundResource(R.drawable.transition_metals);
        platinum.setBackgroundResource(R.drawable.transition_metals);
        gold.setBackgroundResource(R.drawable.transition_metals);
        mercury.setBackgroundResource(R.drawable.transition_metals);
        rutherfordium.setBackgroundResource(R.drawable.transition_metals);
        dubnium.setBackgroundResource(R.drawable.transition_metals);
        seaborgium.setBackgroundResource(R.drawable.transition_metals);
        bhorium.setBackgroundResource(R.drawable.transition_metals);
        hassium.setBackgroundResource(R.drawable.transition_metals);
        meintnerium.setBackgroundResource(R.drawable.transition_metals);
        darmstadium.setBackgroundResource(R.drawable.transition_metals);
        roentgenium.setBackgroundResource(R.drawable.transition_metals);
        copernicium.setBackgroundResource(R.drawable.transition_metals);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);

    }

    public void OnPostTransition(View view) {
        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.post_transition_metals);
        gallium.setBackgroundResource(R.drawable.post_transition_metals);
        indium.setBackgroundResource(R.drawable.post_transition_metals);
        tin.setBackgroundResource(R.drawable.post_transition_metals);
        thallium.setBackgroundResource(R.drawable.post_transition_metals);
        lead.setBackgroundResource(R.drawable.post_transition_metals);
        bismuth.setBackgroundResource(R.drawable.post_transition_metals);
        nihonium.setBackgroundResource(R.drawable.post_transition_metals);
        flerovium.setBackgroundResource(R.drawable.post_transition_metals);
        moscovium.setBackgroundResource(R.drawable.post_transition_metals);
        livermorium.setBackgroundResource(R.drawable.post_transition_metals);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);

    }

    public void OnNonMetals(View view) {
        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.non_metals);
        carbon.setBackgroundResource(R.drawable.non_metals);
        oxygen.setBackgroundResource(R.drawable.non_metals);
        nitrogen.setBackgroundResource(R.drawable.non_metals);
        phosphorus.setBackgroundResource(R.drawable.non_metals);
        sulfur.setBackgroundResource(R.drawable.non_metals);
        selenium.setBackgroundResource(R.drawable.non_metals);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);
    }

    public void OnHalogens(View view) {
        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.halogens);
        chlorine.setBackgroundResource(R.drawable.halogens);
        bromine.setBackgroundResource(R.drawable.halogens);
        iodine.setBackgroundResource(R.drawable.halogens);
        astatine.setBackgroundResource(R.drawable.halogens);
        tennessine.setBackgroundResource(R.drawable.halogens);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);

    }

    public void OnLanthanides(View view) {
        //LANTHANOIDS
        lanthanum.setBackgroundResource(R.drawable.lanthanides);
        cerium.setBackgroundResource(R.drawable.lanthanides);
        praseodymium.setBackgroundResource(R.drawable.lanthanides);
        neodymium.setBackgroundResource(R.drawable.lanthanides);
        promethium.setBackgroundResource(R.drawable.lanthanides);
        samarium.setBackgroundResource(R.drawable.lanthanides);
        europium.setBackgroundResource(R.drawable.lanthanides);
        gadolinium.setBackgroundResource(R.drawable.lanthanides);
        terbium.setBackgroundResource(R.drawable.lanthanides);
        dysprosium.setBackgroundResource(R.drawable.lanthanides);
        holmium.setBackgroundResource(R.drawable.lanthanides);
        erbium.setBackgroundResource(R.drawable.lanthanides);
        thulium.setBackgroundResource(R.drawable.lanthanides);
        ytterbium.setBackgroundResource(R.drawable.lanthanides);
        lutetium.setBackgroundResource(R.drawable.lanthanides);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        b1.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

    }

    public void OnActinides(View view) {
        //ACTINOIDES
        actinium.setBackgroundResource(R.drawable.actinoides);
        uranium.setBackgroundResource(R.drawable.actinoides);
        thorium.setBackgroundResource(R.drawable.actinoides);
        proactinium.setBackgroundResource(R.drawable.actinoides);
        neptonium.setBackgroundResource(R.drawable.actinoides);
        americium.setBackgroundResource(R.drawable.actinoides);
        einsteinium.setBackgroundResource(R.drawable.actinoides);
        lawrencium.setBackgroundResource(R.drawable.actinoides);
        plutonium.setBackgroundResource(R.drawable.actinoides);
        curium.setBackgroundResource(R.drawable.actinoides);
        berkelium.setBackgroundResource(R.drawable.actinoides);
        californium.setBackgroundResource(R.drawable.actinoides);
        fermium.setBackgroundResource(R.drawable.actinoides);
        mendelevium.setBackgroundResource(R.drawable.actinoides);
        nobelium.setBackgroundResource(R.drawable.actinoides);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        lanthanum.setBackgroundResource(R.drawable.grey);
        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

    }

    public void OnMetalloids(View view) {
        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.grey);
        neon.setBackgroundResource(R.drawable.grey);
        argon.setBackgroundResource(R.drawable.grey);
        krypton.setBackgroundResource(R.drawable.grey);
        xenon.setBackgroundResource(R.drawable.grey);
        radon.setBackgroundResource(R.drawable.grey);
        oganesson.setBackgroundResource(R.drawable.grey);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.metalloids);
        silicon.setBackgroundResource(R.drawable.metalloids);
        germanium.setBackgroundResource(R.drawable.metalloids);
        arsenic.setBackgroundResource(R.drawable.metalloids);
        antimony.setBackgroundResource(R.drawable.metalloids);
        tellurium.setBackgroundResource(R.drawable.metalloids);
        polonium.setBackgroundResource(R.drawable.metalloids);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);
    }

    public void OnNoble(View view) {
        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.grey);
        carbon.setBackgroundResource(R.drawable.grey);
        oxygen.setBackgroundResource(R.drawable.grey);
        nitrogen.setBackgroundResource(R.drawable.grey);
        phosphorus.setBackgroundResource(R.drawable.grey);
        sulfur.setBackgroundResource(R.drawable.grey);
        selenium.setBackgroundResource(R.drawable.grey);

        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.grey);
        sodium.setBackgroundResource(R.drawable.grey);
        potassium.setBackgroundResource(R.drawable.grey);
        rubidium.setBackgroundResource(R.drawable.grey);
        cesium.setBackgroundResource(R.drawable.grey);
        francium.setBackgroundResource(R.drawable.grey);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.grey);
        magnesium.setBackgroundResource(R.drawable.grey);
        calcium.setBackgroundResource(R.drawable.grey);
        barium.setBackgroundResource(R.drawable.grey);
        radium.setBackgroundResource(R.drawable.grey);
        strontium.setBackgroundResource(R.drawable.grey);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.noble_gases);
        neon.setBackgroundResource(R.drawable.noble_gases);
        argon.setBackgroundResource(R.drawable.noble_gases);
        krypton.setBackgroundResource(R.drawable.noble_gases);
        xenon.setBackgroundResource(R.drawable.noble_gases);
        radon.setBackgroundResource(R.drawable.noble_gases);
        oganesson.setBackgroundResource(R.drawable.noble_gases);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.grey);
        chlorine.setBackgroundResource(R.drawable.grey);
        bromine.setBackgroundResource(R.drawable.grey);
        iodine.setBackgroundResource(R.drawable.grey);
        astatine.setBackgroundResource(R.drawable.grey);
        tennessine.setBackgroundResource(R.drawable.grey);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.grey);
        silicon.setBackgroundResource(R.drawable.grey);
        germanium.setBackgroundResource(R.drawable.grey);
        arsenic.setBackgroundResource(R.drawable.grey);
        antimony.setBackgroundResource(R.drawable.grey);
        tellurium.setBackgroundResource(R.drawable.grey);
        polonium.setBackgroundResource(R.drawable.grey);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.grey);
        gallium.setBackgroundResource(R.drawable.grey);
        indium.setBackgroundResource(R.drawable.grey);
        tin.setBackgroundResource(R.drawable.grey);
        thallium.setBackgroundResource(R.drawable.grey);
        lead.setBackgroundResource(R.drawable.grey);
        bismuth.setBackgroundResource(R.drawable.grey);
        nihonium.setBackgroundResource(R.drawable.grey);
        flerovium.setBackgroundResource(R.drawable.grey);
        moscovium.setBackgroundResource(R.drawable.grey);
        livermorium.setBackgroundResource(R.drawable.grey);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.grey);
        titanium.setBackgroundResource(R.drawable.grey);
        vanadium.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        manganese.setBackgroundResource(R.drawable.grey);
        iron.setBackgroundResource(R.drawable.grey);
        cobalt.setBackgroundResource(R.drawable.grey);
        nickel.setBackgroundResource(R.drawable.grey);
        chromium.setBackgroundResource(R.drawable.grey);
        copper.setBackgroundResource(R.drawable.grey);
        zinc.setBackgroundResource(R.drawable.grey);

        yttrium.setBackgroundResource(R.drawable.grey);
        zirconium.setBackgroundResource(R.drawable.grey);
        niobium.setBackgroundResource(R.drawable.grey);
        molybdenum.setBackgroundResource(R.drawable.grey);
        technetium.setBackgroundResource(R.drawable.grey);
        ruthenium.setBackgroundResource(R.drawable.grey);
        rhodium.setBackgroundResource(R.drawable.grey);
        palladium.setBackgroundResource(R.drawable.grey);
        silver.setBackgroundResource(R.drawable.grey);
        cadmium.setBackgroundResource(R.drawable.grey);

        hafnium.setBackgroundResource(R.drawable.grey);
        tanlatum.setBackgroundResource(R.drawable.grey);
        tungesten.setBackgroundResource(R.drawable.grey);
        rhenium.setBackgroundResource(R.drawable.grey);
        osmium.setBackgroundResource(R.drawable.grey);
        iridium.setBackgroundResource(R.drawable.grey);
        platinum.setBackgroundResource(R.drawable.grey);
        gold.setBackgroundResource(R.drawable.grey);
        mercury.setBackgroundResource(R.drawable.grey);

        rutherfordium.setBackgroundResource(R.drawable.grey);
        dubnium.setBackgroundResource(R.drawable.grey);
        seaborgium.setBackgroundResource(R.drawable.grey);
        bhorium.setBackgroundResource(R.drawable.grey);
        hassium.setBackgroundResource(R.drawable.grey);
        meintnerium.setBackgroundResource(R.drawable.grey);
        darmstadium.setBackgroundResource(R.drawable.grey);
        roentgenium.setBackgroundResource(R.drawable.grey);
        copernicium.setBackgroundResource(R.drawable.grey);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.grey);
        lanthanum.setBackgroundResource(R.drawable.grey);
        cerium.setBackgroundResource(R.drawable.grey);
        praseodymium.setBackgroundResource(R.drawable.grey);
        neodymium.setBackgroundResource(R.drawable.grey);
        promethium.setBackgroundResource(R.drawable.grey);
        samarium.setBackgroundResource(R.drawable.grey);
        europium.setBackgroundResource(R.drawable.grey);
        gadolinium.setBackgroundResource(R.drawable.grey);
        terbium.setBackgroundResource(R.drawable.grey);
        dysprosium.setBackgroundResource(R.drawable.grey);
        holmium.setBackgroundResource(R.drawable.grey);
        erbium.setBackgroundResource(R.drawable.grey);
        thulium.setBackgroundResource(R.drawable.grey);
        ytterbium.setBackgroundResource(R.drawable.grey);
        lutetium.setBackgroundResource(R.drawable.grey);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.grey);
        uranium.setBackgroundResource(R.drawable.grey);
        thorium.setBackgroundResource(R.drawable.grey);
        proactinium.setBackgroundResource(R.drawable.grey);
        actinium.setBackgroundResource(R.drawable.grey);
        neptonium.setBackgroundResource(R.drawable.grey);
        americium.setBackgroundResource(R.drawable.grey);
        einsteinium.setBackgroundResource(R.drawable.grey);
        lawrencium.setBackgroundResource(R.drawable.grey);
        plutonium.setBackgroundResource(R.drawable.grey);
        curium.setBackgroundResource(R.drawable.grey);
        berkelium.setBackgroundResource(R.drawable.grey);
        californium.setBackgroundResource(R.drawable.grey);
        fermium.setBackgroundResource(R.drawable.grey);
        mendelevium.setBackgroundResource(R.drawable.grey);
        nobelium.setBackgroundResource(R.drawable.grey);
    }

    public void OnAll(View view) {
        //ALKALI METALS
        lithium.setBackgroundResource(R.drawable.alkali_metals);
        sodium.setBackgroundResource(R.drawable.alkali_metals);
        potassium.setBackgroundResource(R.drawable.alkali_metals);
        rubidium.setBackgroundResource(R.drawable.alkali_metals);
        cesium.setBackgroundResource(R.drawable.alkali_metals);
        francium.setBackgroundResource(R.drawable.alkali_metals);

        //NON METALS
        hydrogen.setBackgroundResource(R.drawable.non_metals);
        carbon.setBackgroundResource(R.drawable.non_metals);
        oxygen.setBackgroundResource(R.drawable.non_metals);
        nitrogen.setBackgroundResource(R.drawable.non_metals);
        phosphorus.setBackgroundResource(R.drawable.non_metals);
        sulfur.setBackgroundResource(R.drawable.non_metals);
        selenium.setBackgroundResource(R.drawable.non_metals);

        //ALKALINE EARTH METALS
        beryllium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        magnesium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        calcium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        barium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        radium.setBackgroundResource(R.drawable.alkaline_earth_metals);
        strontium.setBackgroundResource(R.drawable.alkaline_earth_metals);

        //NOBLE GASES
        helium.setBackgroundResource(R.drawable.noble_gases);
        neon.setBackgroundResource(R.drawable.noble_gases);
        argon.setBackgroundResource(R.drawable.noble_gases);
        krypton.setBackgroundResource(R.drawable.noble_gases);
        xenon.setBackgroundResource(R.drawable.noble_gases);
        radon.setBackgroundResource(R.drawable.noble_gases);
        oganesson.setBackgroundResource(R.drawable.noble_gases);

        //HALOGENS
        fluorine.setBackgroundResource(R.drawable.halogens);
        chlorine.setBackgroundResource(R.drawable.halogens);
        bromine.setBackgroundResource(R.drawable.halogens);
        iodine.setBackgroundResource(R.drawable.halogens);
        astatine.setBackgroundResource(R.drawable.halogens);
        tennessine.setBackgroundResource(R.drawable.halogens);

        //METALLOIDS
        boron.setBackgroundResource(R.drawable.metalloids);
        silicon.setBackgroundResource(R.drawable.metalloids);
        germanium.setBackgroundResource(R.drawable.metalloids);
        arsenic.setBackgroundResource(R.drawable.metalloids);
        antimony.setBackgroundResource(R.drawable.metalloids);
        tellurium.setBackgroundResource(R.drawable.metalloids);
        polonium.setBackgroundResource(R.drawable.metalloids);

        //POST TRANSITION METALS
        aluminium.setBackgroundResource(R.drawable.post_transition_metals);
        gallium.setBackgroundResource(R.drawable.post_transition_metals);
        indium.setBackgroundResource(R.drawable.post_transition_metals);
        tin.setBackgroundResource(R.drawable.post_transition_metals);
        thallium.setBackgroundResource(R.drawable.post_transition_metals);
        lead.setBackgroundResource(R.drawable.post_transition_metals);
        bismuth.setBackgroundResource(R.drawable.post_transition_metals);
        nihonium.setBackgroundResource(R.drawable.post_transition_metals);
        flerovium.setBackgroundResource(R.drawable.post_transition_metals);
        moscovium.setBackgroundResource(R.drawable.post_transition_metals);
        livermorium.setBackgroundResource(R.drawable.post_transition_metals);

        //MAIN TRANSITION METALS
        scandmium.setBackgroundResource(R.drawable.transition_metals);
        titanium.setBackgroundResource(R.drawable.transition_metals);
        vanadium.setBackgroundResource(R.drawable.transition_metals);
        chromium.setBackgroundResource(R.drawable.transition_metals);
        manganese.setBackgroundResource(R.drawable.transition_metals);
        iron.setBackgroundResource(R.drawable.transition_metals);
        cobalt.setBackgroundResource(R.drawable.transition_metals);
        nickel.setBackgroundResource(R.drawable.transition_metals);
        chromium.setBackgroundResource(R.drawable.transition_metals);
        zinc.setBackgroundResource(R.drawable.transition_metals);
        copper.setBackgroundResource(R.drawable.transition_metals);
        yttrium.setBackgroundResource(R.drawable.transition_metals);
        zirconium.setBackgroundResource(R.drawable.transition_metals);
        niobium.setBackgroundResource(R.drawable.transition_metals);
        molybdenum.setBackgroundResource(R.drawable.transition_metals);
        technetium.setBackgroundResource(R.drawable.transition_metals);
        ruthenium.setBackgroundResource(R.drawable.transition_metals);
        rhodium.setBackgroundResource(R.drawable.transition_metals);
        palladium.setBackgroundResource(R.drawable.transition_metals);
        silver.setBackgroundResource(R.drawable.transition_metals);
        cadmium.setBackgroundResource(R.drawable.transition_metals);
        hafnium.setBackgroundResource(R.drawable.transition_metals);
        tanlatum.setBackgroundResource(R.drawable.transition_metals);
        tungesten.setBackgroundResource(R.drawable.transition_metals);
        rhenium.setBackgroundResource(R.drawable.transition_metals);
        osmium.setBackgroundResource(R.drawable.transition_metals);
        iridium.setBackgroundResource(R.drawable.transition_metals);
        platinum.setBackgroundResource(R.drawable.transition_metals);
        gold.setBackgroundResource(R.drawable.transition_metals);
        mercury.setBackgroundResource(R.drawable.transition_metals);
        rutherfordium.setBackgroundResource(R.drawable.transition_metals);
        dubnium.setBackgroundResource(R.drawable.transition_metals);
        seaborgium.setBackgroundResource(R.drawable.transition_metals);
        bhorium.setBackgroundResource(R.drawable.transition_metals);
        hassium.setBackgroundResource(R.drawable.transition_metals);
        meintnerium.setBackgroundResource(R.drawable.transition_metals);
        darmstadium.setBackgroundResource(R.drawable.transition_metals);
        roentgenium.setBackgroundResource(R.drawable.transition_metals);
        copernicium.setBackgroundResource(R.drawable.transition_metals);

        //LANTHANOIDS
        b1.setBackgroundResource(R.drawable.lanthanides);
        lanthanum.setBackgroundResource(R.drawable.lanthanides);
        cerium.setBackgroundResource(R.drawable.lanthanides);
        praseodymium.setBackgroundResource(R.drawable.lanthanides);
        neodymium.setBackgroundResource(R.drawable.lanthanides);
        promethium.setBackgroundResource(R.drawable.lanthanides);
        samarium.setBackgroundResource(R.drawable.lanthanides);
        europium.setBackgroundResource(R.drawable.lanthanides);
        gadolinium.setBackgroundResource(R.drawable.lanthanides);
        terbium.setBackgroundResource(R.drawable.lanthanides);
        dysprosium.setBackgroundResource(R.drawable.lanthanides);
        holmium.setBackgroundResource(R.drawable.lanthanides);
        erbium.setBackgroundResource(R.drawable.lanthanides);
        thulium.setBackgroundResource(R.drawable.lanthanides);
        ytterbium.setBackgroundResource(R.drawable.lanthanides);
        lutetium.setBackgroundResource(R.drawable.lanthanides);

        //ACTINOIDES
        b2.setBackgroundResource(R.drawable.actinoides);
        actinium.setBackgroundResource(R.drawable.actinoides);
        uranium.setBackgroundResource(R.drawable.actinoides);
        thorium.setBackgroundResource(R.drawable.actinoides);
        proactinium.setBackgroundResource(R.drawable.actinoides);
        neptonium.setBackgroundResource(R.drawable.actinoides);
        americium.setBackgroundResource(R.drawable.actinoides);
        einsteinium.setBackgroundResource(R.drawable.actinoides);
        lawrencium.setBackgroundResource(R.drawable.actinoides);
        plutonium.setBackgroundResource(R.drawable.actinoides);
        curium.setBackgroundResource(R.drawable.actinoides);
        berkelium.setBackgroundResource(R.drawable.actinoides);
        californium.setBackgroundResource(R.drawable.actinoides);
        fermium.setBackgroundResource(R.drawable.actinoides);
        mendelevium.setBackgroundResource(R.drawable.actinoides);
        nobelium.setBackgroundResource(R.drawable.actinoides);
    }

    public void onH(View view) {
        GetData("Hydrogen",R.drawable.hydrogen_photo, getResources().getColor(R.color.non_metal3));
    }

    public void OnHe(View view) {
        GetData("Helium",R.drawable.helium_photo , getResources().getColor(R.color.halogens3));
    }

    public void OnLithium(View view) {
        GetData("Lithium",R.drawable.lithium_photo , getResources().getColor(R.color.alkali_metals3));
    }

    public void OnBeryllium(View view) {
        GetData("Beryllium",R.drawable.beryllium_photo , getResources().getColor(R.color.alkaline_earth_metal3));
    }

    public void OnBoron(View view) {
        GetData("Boron",R.drawable.boron_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnC(View view) {
        GetData("Carbon",R.drawable.carbon_photo , getResources().getColor(R.color.non_metal3));
    }

    public void OnN(View view){
        GetData("Nitrogen",R.drawable.nitrogen_photo, getResources().getColor(R.color.non_metal3));
    }

    public void OnO(View view){
        GetData("Oxygen",R.drawable.oxygen_photo, getResources().getColor(R.color.non_metal3));
    }

    public void onF(View view){
        GetData("Fluorine",R.drawable.fluorine_photo, getResources().getColor(R.color.halogens3));
    }

    public void onNe(View view){
        GetData("Neon",R.drawable.neon_photo, getResources().getColor(R.color.nobel3));
    }

    public void OnSodium(View view) {
        GetData("Sodium",R.drawable.sodium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnMagnesium(View view) {
        GetData("Magnesium",R.drawable.magnesium_photo, getResources().getColor(R.color.alkaline_earth_metal3));
    }

    public void OnAl (View view){
        GetData("Aluminum",R.drawable.aluminium_photo , getResources().getColor(R.color.non_metal3));
    }

    public void OnSi (View view){
        GetData("Silicon",R.drawable.silicon_photo, getResources().getColor(R.color.metalloids3));
    }

    public void onP (View view){
        GetData("Phosphorus",R.drawable.phosphorus_photo, getResources().getColor(R.color.non_metal3));
    }

    public void onS (View view){
        GetData("Sulfur",R.drawable.sulfur_photo, getResources().getColor(R.color.non_metal3));
    }

    public void onCl (View view){
        GetData("Chlorine",R.drawable.chlorine_photo, getResources().getColor(R.color.halogens3));
    }

    public void onAr (View view){
        GetData("Argon",R.drawable.argon_photo, getResources().getColor(R.color.nobel3));
    }

    public void OnPotassium(View view) {
        GetData("Potassium",R.drawable.potassium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnCalcium(View view) {
        GetData("Calcium",R.drawable.calcium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnScandium(View view) {
        GetData("Scandium",R.drawable.scandium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnTitanium(View view) {
        GetData("Titanium",R.drawable.titanium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnVanad(View view) {
        GetData("Vanadium",R.drawable.vanadium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnChromium(View view) {
        GetData("Chromium",R.drawable.chromium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnManganese(View view) {
        GetData("Manganese",R.drawable.manganese_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnFe (View view){
        GetData("Iron",R.drawable.iron_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnCo(View view) {
        GetData("Cobalt",R.drawable.cobalt_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnRb(View view) {
        GetData("Rubidium",R.drawable.rubidium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void onSe(View view) {
        GetData("Selenium",R.drawable.selenium_photo , getResources().getColor(R.color.non_metal3));
    }

    public void OnStrontium(View view) {
        GetData("Strontium",R.drawable.strontium_photo , getResources().getColor(R.color.alkali_metals3));
    }

    public void OnZr(View view) {
        GetData("Zirconium",R.drawable.zirconium_photo , getResources().getColor(R.color.transition_metals3));
    }

    public void OnNb(View view) {
        GetData("Niobium",R.drawable.niobium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnMo(View view) {
        GetData("Molybdenum",R.drawable.molybdenum_phot, getResources().getColor(R.color.transition_metals3));
    }

    public void OnCs(View view) {
        GetData("Cesium",R.drawable.cesium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnBa(View view) {
        GetData("Barium",R.drawable.barium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnHf(View view) {
        GetData("Hafnium",R.drawable.hafnium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnTa(View view) {
        GetData("Tantalum",R.drawable.tantalum_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnW(View view) {
        GetData("Tungsten",R.drawable.tungsten_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnFr(View view) {
        GetData("Francium",R.drawable.francium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnRa(View view) {
        GetData("Radium",R.drawable.radium_photo, getResources().getColor(R.color.alkali_metals3));
    }

    public void OnRf(View view) {
        GetData("Rutherfordium",R.drawable.rutherfordium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnDb(View view) {
        GetData("Dubnium",R.drawable.dubnium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnSg(View view) {
        GetData("Seaborgium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnTc(View view) {
        GetData("Technetium",R.drawable.technetium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnRe(View view) {
        GetData("Rhenium",R.drawable.rhenium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnBh(View view) {
        GetData("Bohrium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnRu(View view) {
        GetData("Ruthenium",R.drawable.ruthenium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnIr(View view){
        GetData("Iridium",R.drawable.iridium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnOs(View view) {
        GetData("Osmium",R.drawable.osmium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnHs(View view) {
        GetData("Hassium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnRh(View view) {
        GetData("Rhodium",R.drawable.rhodium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnMt(View view) {
        GetData("Meitnerium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnNi(View view) {
        GetData("Nickel",R.drawable.nickel_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnPd(View view) {
        GetData("Palladium",R.drawable.palladium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnDs(View view) {
        GetData("Darmstadtium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnPt(View view) {
        GetData("Platinum",R.drawable.platinum_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnCu(View view) {
        GetData("Copper",R.drawable.copper_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnAg(View view) {
        GetData("Silver",R.drawable.silver_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnAu(View view) {
        GetData("Gold",R.drawable.gold_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnRg(View view) {
        GetData("Roentgenium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnCn(View view) {
        GetData("Copernicium",R.drawable.bohrium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnZn(View view) {
        GetData("Zinc",R.drawable.zinc_photo, getResources().getColor(R.color.transition_metals3));
    }


    public void OnCd(View view) {
        GetData("Cadmium",R.drawable.cadmium_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnHg(View view) {
        GetData("Mercury",R.drawable.mercury_photo, getResources().getColor(R.color.transition_metals3));
    }

    public void OnGa(View view) {
        GetData("Gallium",R.drawable.gallium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnGe(View view){
        GetData("Germanium",R.drawable.germanium_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnAs(View view) {
        GetData("Arsenic",R.drawable.arsenic_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnSb(View view) {
        GetData("Antimony",R.drawable.antimony_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnTe(View view) {
        GetData("Tellurium",R.drawable.tellurium_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnPo(View view) {
        GetData("Polonium",R.drawable.polonium_photo, getResources().getColor(R.color.metalloids3));
    }

    public void OnBr(View view) {
        GetData("Bromine",R.drawable.bromine_photo, getResources().getColor(R.color.halogens3));
    }

    public void onKr(View view) {
        GetData("Krypton",R.drawable.krypton_photo, getResources().getColor(R.color.nobel3));
    }

    public void OnY(View view) {
        GetData("Yttrium",R.drawable.yttrium_photo, getResources().getColor(R.color.transition_metals3));
    }


    public void OnIn(View view) {
        GetData("Indium",R.drawable.indium_photo , getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnSn(View view) {
        GetData("Tin",R.drawable.tin_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnI(View view) {
        GetData("Iodine",R.drawable.iodine_photo, getResources().getColor(R.color.halogens3));
    }

    public void OnCe(View view) {
        GetData("Cerium",R.drawable.cerium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void onLa(View view) {
        GetData("Lanthanum",R.drawable.lanthanum_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnPr(View view) {
        GetData("Praseodymium",R.drawable.praseodymium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnXe(View view) {
        GetData("Xenon",R.drawable.xenon_photo, getResources().getColor(R.color.nobel3));
    }

    public void OnNd(View view) {
        GetData("Neodymium",R.drawable.neodymium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnPm(View view) {
        GetData("Promethium",R.drawable.promethium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnSm(View view) {
        GetData("Samarium",R.drawable.samarium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnEu(View view) {
        GetData("Europium",R.drawable.europium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnGd(View view) {
        GetData("Gadolinium",R.drawable.gadolinium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnTb(View view) {
        GetData("Terbium",R.drawable.terbium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnDy(View view) {
        GetData("Dysprosium",R.drawable.dysprosium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnHo(View view) {
        GetData("Holmium",R.drawable.holmium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnEr(View view) {
        GetData("Erbium",R.drawable.erbium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnTm(View view) {
        GetData("Thulium",R.drawable.thulium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnYb(View view) {
        GetData("Ytterbium",R.drawable.yttrbium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnLu(View view) {
        GetData("Lutetium",R.drawable.lutetium_photo, getResources().getColor(R.color.lanthanides3));
    }

    public void OnTl(View view) {
        GetData("Thallium",R.drawable.thulium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnPb(View view) {
        GetData("Lead",R.drawable.lead_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnBi(View view) {
        GetData("Bismuth",R.drawable.bismuth_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnAt(View view) {
        GetData("Astatine",R.drawable.astatine_photo, getResources().getColor(R.color.halogens3));
    }

    public void OnRn(View view) {
        GetData("Radon",R.drawable.radon_photo, getResources().getColor(R.color.nobel3));
    }

    public void OnAc(View view) {
        GetData("Actinium",R.drawable.actinium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnPa(View view) {
        GetData("Protactinium",R.drawable.protactinium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnU(View view) {
        GetData("Uranium",R.drawable.uranium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnNp(View view) {
        GetData("Neptunium",R.drawable.neptunium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnPu(View view) {
        GetData("Plutonium",R.drawable.plutonium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnAm(View view) {
        GetData("Americium",R.drawable.americium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnCm(View view) {
        GetData("Curium",R.drawable.curium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnTh(View view) {
        GetData("Thorium",R.drawable.thorium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnBk(View view) {
        GetData("Berkelium",R.drawable.berkelium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnCf(View view) {
        GetData("Californium",R.drawable.californium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnEs(View view) {
        GetData("Einsteinium",R.drawable.einsteinium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnFm(View view) {
        GetData("Fermium",R.drawable.fermium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnMd(View view) {
        GetData("Mendelevium",R.drawable.mendelevium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnNo(View view) {
        GetData("Nobelium",R.drawable.nobelium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnLr(View view) {
        GetData("Lawrencium",R.drawable.lawrencium_photo, getResources().getColor(R.color.actinoides3));
    }

    public void OnNh(View view) {
        GetData("Nihonium",R.drawable.nihonium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnFl(View view) {
        GetData("Flerovium",R.drawable.nihonium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnMs(View view) {
        GetData("Moscovium",R.drawable.nihonium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnLv(View view) {
        GetData("Livermorium",R.drawable.nihonium_photo, getResources().getColor(R.color.post_transition_metals3));
    }

    public void OnTs(View view) {
        GetData("Tennessine",R.drawable.tennessine_photo, getResources().getColor(R.color.halogens3));
    }

    public void OnOg(View view) {
        GetData("Oganesson",R.drawable.oganesson_photo, getResources().getColor(R.color.nobel3));
    }

    private void GetData(String name, int res, int color){
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();
            String n = name;

            Intent intent= new Intent(getApplicationContext(),ScrollingActivity.class);
            intent.putExtra("1",databaseAccess.getLatinName(n));
            intent.putExtra("2",databaseAccess.getEnglishName(n));
            intent.putExtra("3",databaseAccess.getYear(n));
            intent.putExtra("4",databaseAccess.getDiscoverer(n));
            intent.putExtra("5",databaseAccess.getCasNumber(n));
            intent.putExtra("6",databaseAccess.getAtomicNumber(n));
            intent.putExtra("7",databaseAccess.getPeriodGroup(n));
            intent.putExtra("8",databaseAccess.getBlocks(n));
            intent.putExtra("9",databaseAccess.getElementCategory(n));
            intent.putExtra("10",databaseAccess.getNumberOfProtons(n));
            intent.putExtra("11",databaseAccess.getNumberOfElectrons(n));
            intent.putExtra("12",databaseAccess.getNumberOfNeutrons(n));
            intent.putExtra("13",databaseAccess.getAtomicWeight(n));
            intent.putExtra("14",databaseAccess.getElectronicConfiguration(n));
            intent.putExtra("16",databaseAccess.getElectronShell(n));
            intent.putExtra("17",databaseAccess.getIonCharge(n));
            intent.putExtra("18",databaseAccess.getIonizationPotential(n));
            intent.putExtra("19",databaseAccess.getOxidationState(n) );
            intent.putExtra("20",databaseAccess.getAtomicRadius(n));
            intent.putExtra("21",databaseAccess.getCovalentRadius(n));
            intent.putExtra("22",databaseAccess.getVanDerWaalsRadius(n));
            intent.putExtra("23",databaseAccess.getDensity(n));
            intent.putExtra("24",databaseAccess.getPhysicalState(n));
            intent.putExtra("25",databaseAccess.getColor(n));
            intent.putExtra("26",databaseAccess.getMeltingPoint(n));
            intent.putExtra("27",databaseAccess.getBoilingPoint(n));
            intent.putExtra("28",databaseAccess.getElectronegativity(n));
            intent.putExtra("29",databaseAccess.getValence(n));
            intent.putExtra("30",databaseAccess.getElectronAffinity(n));
            intent.putExtra("31",databaseAccess.getFusionHeat(n));
            intent.putExtra("32",databaseAccess.getSpecificHeat(n));
            intent.putExtra("33",databaseAccess.getVaporizationHeat(n));
            intent.putExtra("34",databaseAccess.getElectricalConductivity(n));
            intent.putExtra("35",databaseAccess.getElectricalType(n));
            intent.putExtra("36",databaseAccess.getMagneticType(n));
            intent.putExtra("37",databaseAccess.getMolarMagneticSusceptibility(n));
            intent.putExtra("38",databaseAccess.getMassMagneticSusceptibility(n));
            intent.putExtra("39",databaseAccess.getVolumeMagneticSusceptibility(n));
            intent.putExtra("40",databaseAccess.getResistivity(n));
            intent.putExtra("41",databaseAccess.getInUniverse(n));
            intent.putExtra("42",databaseAccess.getInSun(n));
            intent.putExtra("43",databaseAccess.getInMeteorites(n));
            intent.putExtra("44",databaseAccess.getInEarthCrust(n));
            intent.putExtra("45",databaseAccess.getInOceans(n));
            intent.putExtra("46",databaseAccess.getInHumanBody(n));
            intent.putExtra("47",databaseAccess.getRadioActive(n));
            intent.putExtra("48",databaseAccess.getHalfLifeTime(n));
            intent.putExtra("49",databaseAccess.getDecayMode(n));
            intent.putExtra("50",databaseAccess.getUsesAndImportance(n));
            intent.putExtra("51",databaseAccess.getUsesAndImportance2(n));
            intent.putExtra("52",databaseAccess.getUsesAndImportance3(n));
            intent.putExtra("53",databaseAccess.getEnglishName(n));
            intent.putExtra("54",databaseAccess.getLinks(n));
            Bundle bundle=new Bundle();
            bundle.putInt("55",res);
            bundle.putInt("56",color);
            intent.putExtras(bundle);

            databaseAccess.close();
            startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    private void GetLongData(String name, int image1, int image2){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_inflater, null);
        imageView= view.findViewById(R.id.imageViewEasy);
        imageView2= view.findViewById(R.id.imageViewEasy2);
        name_view= view.findViewById(R.id.name);
        atomic_weight_view= view.findViewById(R.id.atomic_weight);
        cas_view= view.findViewById(R.id.CAS_no);
        category_view= view.findViewById(R.id.category);
        electron_view= view.findViewById(R.id.electron_shell);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        imageView.setBackgroundResource(image1);
        imageView2.setBackgroundResource(image2);
        name_view.setText(databaseAccess.getEnglishName(name));
        atomic_weight_view.setText("Atomic weight:  " + databaseAccess.getAtomicWeight(name));
        cas_view.setText("CAS No:  " + databaseAccess.getCasNumber(name));
        electron_view.setText("Electron shell:  " + databaseAccess.getElectronShell(name));
        category_view.setText("Category:  " + databaseAccess.getElementCategory(name));
        alertDialog.setView(view);
        AlertDialog alert = alertDialog.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();
        databaseAccess.close();
    }
}

/*
        final LinearLayout lyperiod=(LinearLayout)findViewById(R.id.lyperiods);
        final LinearLayout lygroup=(LinearLayout)findViewById(R.id.lygroups);
        final TextView g1=(TextView)findViewById(R.id.g1);
        final TextView g2=(TextView)findViewById(R.id.g2);
        final TextView g3=(TextView)findViewById(R.id.g3);
        final TextView g4=(TextView)findViewById(R.id.g4);
        final TextView g5=(TextView)findViewById(R.id.g5);
        final TextView g6=(TextView)findViewById(R.id.g6);
        final TextView g7=(TextView)findViewById(R.id.g7);
        final TextView g8=(TextView)findViewById(R.id.g8);
        final TextView g9=(TextView)findViewById(R.id.g9);
        final TextView g10=(TextView)findViewById(R.id.g10);
        final TextView g11=(TextView)findViewById(R.id.g11);
        final TextView g12=(TextView)findViewById(R.id.g12);
        final TextView g13=(TextView)findViewById(R.id.g13);
        final TextView g14=(TextView)findViewById(R.id.g14);
        final TextView g15=(TextView)findViewById(R.id.g15);
        final TextView g16=(TextView)findViewById(R.id.g16);
        final TextView g17=(TextView)findViewById(R.id.g17);
        final TextView g18=(TextView)findViewById(R.id.g18);
        final TextView p1=(TextView)findViewById(R.id.p1);
        final TextView p2=(TextView)findViewById(R.id.p2);
        final TextView p3=(TextView)findViewById(R.id.p3);
        final TextView p4=(TextView)findViewById(R.id.p4);
        final TextView p5=(TextView)findViewById(R.id.p5);
        final TextView p6=(TextView)findViewById(R.id.p6);
        final TextView p7=(TextView)findViewById(R.id.p7);
        final TextView p8=(TextView)findViewById(R.id.p8);
        final TextView p9=(TextView)findViewById(R.id.p9);
*/
