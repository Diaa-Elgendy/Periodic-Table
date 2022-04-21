package com.elgendy.periodictable2020;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ScrollingActivity extends AppCompatActivity {

    SharedPref sharedpref;
    TextView TextViewOverView, TextViewProperties, TextViewAtomic, TextViewPhysical, TextViewReactivity, TextViewThermo, TextViewElectro, TextViewAbundance, TextViewNuclear, TextViewUsesTitle, TextViewLatinName, TextViewEnglishName, TextViewYearOfDiscovery, TextViewDiscoverer, TextViewCASNumber, TextViewAtomicNumber, TextViewPeriodGroup, TextViewBlock, TextViewElementCategory, TextViewNumberOfProtons, TextViewNumberOfElectrons, TextViewNumberofneutrons, TextViewAtomicWeight, TextViewElectronicConfiguration, TextViewElectronShell, TextViewIonCharge, TextViewIonizationEnergy, TextViewOxidationState, TextViewAtomicRadius, TextViewCovalentRadius, TextViewVanDerWaalsRadius, TextViewDensity, TextViewPhysicatState, TextViewColor, TextViewMeltingPoint, TextViewBolingPoint, TextViewElectronegativity, TextViewValence, TextViewElectronAffinity, TextViewFusionHeat, TextViewSpecificHeat, TextViewVaporizationHeat, TextViewElectricalConductivity, TextViewElectricalType, TextViewmagneticType, TextViewMolar, TextViewMass, TextViewVolume, TextViewResistivity, TextViewUniverse, TextViewSun, TextViewMeteorites, TextViewEarth, TextViewOceans, TextViewHuman, TextViewRadioactive, TextViewHalfLifeTime, TextViewDecayMode, TextViewUses, TextViewUses2, TextViewUses3;
    CollapsingToolbarLayout collapsingToolbarLayout;
    //NestedScrollView nestedScrollView;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()) {
            setTheme(R.style.DarkTheme);
        }
        else  setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
/*
        MobileAds.initialize(this, "ca-app-pub-3302117490032015/4841731903");
        AdView adView = findViewById(R.id.adView);
        AdView adView2 = findViewById(R.id.adView2);
        AdView adView3 = findViewById(R.id.adView3);
        AdView adView4 = findViewById(R.id.adView4);
        AdView adView5 = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
        adView2.loadAd(adRequest);
        adView3.loadAd(adRequest);
        adView4.loadAd(adRequest);
        adView5.loadAd(adRequest);
*/
        collapsingToolbarLayout= findViewById(R.id.toolbar_layout);

        Toolbar toolbar = findViewById(R.id.toolbar_scrolling);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextViewOverView = findViewById(R.id.title_over_view);
        TextViewProperties= findViewById(R.id.properties);
        TextViewAtomic = findViewById(R.id.atomic_properties);
        TextViewPhysical = findViewById(R.id.physical_properties);
        TextViewReactivity = findViewById(R.id.reactivity);
        TextViewThermo = findViewById(R.id.thermodynamic_properties);
        TextViewElectro= findViewById(R.id.electromagnetic_properties);
        TextViewAbundance= findViewById(R.id.abundances);
        TextViewUsesTitle= findViewById(R.id.uses_importance);
        TextViewNuclear= findViewById(R.id.nuclear_properties);

        TextViewLatinName= findViewById(R.id.latin_name);
        TextViewEnglishName= findViewById(R.id.english_name);
        TextViewYearOfDiscovery= findViewById(R.id.year_of_discovery);
        TextViewDiscoverer= findViewById(R.id.discoverer);
        TextViewCASNumber= findViewById(R.id.cas_number);
        TextViewAtomicNumber= findViewById(R.id.atomic_number);
        TextViewPeriodGroup= findViewById(R.id.period_group);
        TextViewBlock= findViewById(R.id.block);
        TextViewElementCategory= findViewById(R.id.Element_category);
        TextViewNumberOfProtons= findViewById(R.id.number_of_protons);
        TextViewNumberOfElectrons= findViewById(R.id.Number_of_electrons);
        TextViewNumberofneutrons= findViewById(R.id.Number_of_neutrons);
        TextViewAtomicWeight= findViewById(R.id.atomic_weight);
        TextViewElectronicConfiguration= findViewById(R.id.electronic_configuration);
        TextViewElectronShell= findViewById(R.id.electron_shell);
        TextViewIonCharge= findViewById(R.id.ion_charge);
        TextViewIonizationEnergy= findViewById(R.id.ionization_energy);
        TextViewOxidationState= findViewById(R.id.oxidation_state);
        TextViewAtomicRadius= findViewById(R.id.atomic_radius);
        TextViewCovalentRadius= findViewById(R.id.covalent_radius);
        TextViewVanDerWaalsRadius= findViewById(R.id.van_der_waals_radius);
        TextViewDensity= findViewById(R.id.density);
        TextViewPhysicatState= findViewById(R.id.physical_state);
        TextViewColor= findViewById(R.id.color);
        TextViewMeltingPoint= findViewById(R.id.melting_point);
        TextViewBolingPoint= findViewById(R.id.boiling_point);
        TextViewElectronegativity= findViewById(R.id.electronegativity);
        TextViewValence= findViewById(R.id.valence);
        TextViewElectronAffinity= findViewById(R.id.electron_affinity);
        TextViewFusionHeat= findViewById(R.id.fusion_heat);
        TextViewSpecificHeat= findViewById(R.id.specific_heat);
        TextViewVaporizationHeat= findViewById(R.id.vaporization_heat);
        TextViewElectricalConductivity= findViewById(R.id.electrical_conductivity);
        TextViewElectricalType= findViewById(R.id.electrical_type);
        TextViewmagneticType= findViewById(R.id.magnetic_type);
        TextViewMolar= findViewById(R.id.molar_magnetic_susceptibility);
        TextViewMass= findViewById(R.id.mass_magnetic_susceptibility);
        TextViewVolume= findViewById(R.id.volume_magnetic_susceptibility);
        TextViewResistivity= findViewById(R.id.resistivity);
        TextViewUniverse= findViewById(R.id.in_universe);
        TextViewSun= findViewById(R.id.in_sun);
        TextViewMeteorites= findViewById(R.id.in_meteorites);
        TextViewEarth= findViewById(R.id.in_earth_s_crust);
        TextViewOceans= findViewById(R.id.in_oceans);
        TextViewHuman= findViewById(R.id.in_human_body);
        TextViewRadioactive= findViewById(R.id.radioactive);
        TextViewHalfLifeTime= findViewById(R.id.half_life_time);
        TextViewDecayMode= findViewById(R.id.decay_mode);
        TextViewUses= findViewById(R.id.uses_importance1);
        TextViewUses2= findViewById(R.id.uses_importance2);
        TextViewUses3= findViewById(R.id.uses_importance3);

        //To get data from the previous activity
        Intent get = getIntent();
        Bundle bundle = this.getIntent().getExtras();

        TextViewLatinName.setText(get.getStringExtra("1"));
        TextViewEnglishName.setText(get.getStringExtra("2"));
        TextViewYearOfDiscovery.setText(get.getStringExtra("3"));
        TextViewDiscoverer.setText(get.getStringExtra("4"));
        TextViewCASNumber.setText("CAS " + get.getStringExtra("5"));
        TextViewAtomicNumber.setText(get.getStringExtra("6"));
        TextViewPeriodGroup.setText(get.getStringExtra("7"));
        TextViewBlock.setText(get.getStringExtra("8"));
        TextViewElementCategory.setText(get.getStringExtra("9"));
        TextViewNumberOfProtons.setText(get.getStringExtra("10"));
        TextViewNumberOfElectrons.setText(get.getStringExtra("11"));
        TextViewNumberofneutrons.setText(get.getStringExtra("12"));
        TextViewAtomicWeight.setText(get.getStringExtra("13") + " u");
        TextViewElectronicConfiguration.setText(get.getStringExtra("14"));
        TextViewElectronShell.setText(get.getStringExtra("16"));
        TextViewIonCharge.setText(get.getStringExtra("17"));
        TextViewIonizationEnergy.setText(get.getStringExtra("18"));
        TextViewOxidationState.setText(get.getStringExtra("19"));
        TextViewAtomicRadius.setText(get.getStringExtra("20"));
        TextViewCovalentRadius.setText(get.getStringExtra("21"));
        TextViewVanDerWaalsRadius.setText(get.getStringExtra("22"));
        TextViewDensity.setText(get.getStringExtra("23") + " g/cm³");
        TextViewPhysicatState.setText(get.getStringExtra("24"));
        TextViewColor.setText(get.getStringExtra("25"));
        TextViewMeltingPoint.setText(get.getStringExtra("26"));
        TextViewBolingPoint.setText(get.getStringExtra("27"));
        TextViewElectronegativity.setText(get.getStringExtra("28"));
        TextViewValence.setText(get.getStringExtra("29"));
        TextViewElectronAffinity.setText(get.getStringExtra("30"));
        TextViewFusionHeat.setText(get.getStringExtra("31"));
        TextViewSpecificHeat.setText(get.getStringExtra("32"));
        TextViewVaporizationHeat.setText(get.getStringExtra("33"));
        TextViewElectricalConductivity.setText(get.getStringExtra("34"));
        TextViewElectricalType.setText(get.getStringExtra("35"));
        TextViewmagneticType.setText(get.getStringExtra("36"));
        TextViewMolar.setText(get.getStringExtra("37"));
        TextViewMass.setText(get.getStringExtra("38"));
        TextViewVolume.setText(get.getStringExtra("39"));
        TextViewResistivity.setText(get.getStringExtra("40"));
        TextViewUniverse.setText(get.getStringExtra("41"));
        TextViewSun.setText(get.getStringExtra("42"));
        TextViewMeteorites.setText(get.getStringExtra("43"));
        TextViewEarth.setText(get.getStringExtra("44"));
        TextViewOceans.setText(get.getStringExtra("45"));
        TextViewHuman.setText(get.getStringExtra("46"));
        TextViewRadioactive.setText(get.getStringExtra("47"));
        TextViewHalfLifeTime.setText(get.getStringExtra("48"));
        TextViewDecayMode.setText(get.getStringExtra("49"));
        TextViewUses.setText("1) " + get.getStringExtra("50"));
        TextViewUses2.setText("2) " + get.getStringExtra("51"));
        TextViewUses3.setText("3) " + get.getStringExtra("52"));
        collapsingToolbarLayout.setTitle(get.getStringExtra("53"));
        collapsingToolbarLayout.setBackgroundResource(bundle.getInt("55"));
        collapsingToolbarLayout.setContentScrimColor(bundle.getInt("56"));
        TextViewOverView.setTextColor(bundle.getInt("56"));
        TextViewProperties.setTextColor(bundle.getInt("56"));
        TextViewAtomic.setTextColor(bundle.getInt("56"));
        TextViewReactivity.setTextColor(bundle.getInt("56"));
        TextViewPhysical.setTextColor(bundle.getInt("56"));
        TextViewUsesTitle.setTextColor(bundle.getInt("56"));
        TextViewThermo.setTextColor(bundle.getInt("56"));
        TextViewElectro.setTextColor(bundle.getInt("56"));
        TextViewNuclear.setTextColor(bundle.getInt("56"));
        TextViewAbundance.setTextColor(bundle.getInt("56"));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(bundle.getInt("56"));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_element,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.wiki) {
            Intent get=getIntent();
            String link = get.getStringExtra("54");
            Uri uri = Uri.parse(link);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    public void OnCollape(View view) {
        /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(ScrollingActivity.this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.image_inflater, null);
        ImageView imageView= view1.findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.hydrogen_photo);
        alertDialog.setView(view1);
        AlertDialog alert = alertDialog.create();
        alert.show();*/
    }
}
