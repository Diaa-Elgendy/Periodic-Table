package com.elgendy.periodictable2020.Search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.elgendy.periodictable2020.R;
import com.elgendy.periodictable2020.ScrollingActivity;
import com.elgendy.periodictable2020.SharedPref;

public class SearchActivity extends AppCompatActivity {

    SharedPref sharedpref;
    RecyclerView recyclerView;
    List<SearchHolder> SearchHolderList= new ArrayList<>();
    SearchAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new SharedPref(this);
        if (sharedpref.loadNightModeState()) { setTheme(R.style.DarkTheme); }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerSearch);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter2 = new SearchAdapter(SearchHolderList, SearchActivity.this);
        recyclerView.setAdapter(adapter2);


        SearchHolderList.add(new SearchHolder(1, "Hydrogen", "Non metals","Atomic no: 1", R.drawable.hydrogen_photo_min ,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(2, "Helium", "Noble gases","Atomic no: 2", R.drawable.helium_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(3, "Lithium", "Alkali metals","Atomic no: 3", R.drawable.lithium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Beryllium", "Alkaline earth","Atomic no: 4", R.drawable.beryllium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Boron", "Metalloids","Atomic no: 5", R.drawable.boron_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Carbon",  "Non metals","Atomic no: 6", R.drawable.carbon_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Nitrogen",  "Non metals","Atomic no: 7", R.drawable.nitrogen_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Oxygen",  "Non metals","Atomic no: 8", R.drawable.oxygen_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Fluorine",  "Halogens","Atomic no: 9", R.drawable.fluorine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Neon",  "Noble gases","Atomic no: 10", R.drawable.neon_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(1, "Sodium",  "Alkali metals","Atomic no: 11", R.drawable.sodium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Magnesium",  "Alkaline earth","Atomic no: 12", R.drawable.magnesium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Aluminium",  "Post transition","Atomic no: 13", R.drawable.aluminium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Silicon",  "Metalloids", "Atomic no: 14",R.drawable.silicon_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Phosphorus",  "Non metals", "Atomic no: 15",R.drawable.phosphorus_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Sulfur",  "Non metals", "Atomic no: 16",R.drawable.sulfur_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Chlorine",  "Halogens", "Atomic no: 17",R.drawable.chlorine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Argon",  "Noble gases", "Atomic no: 18",R.drawable.argon_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(1, "Potassium",  "Alkali metals","Atomic no: 19", R.drawable.potassium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Calcium",  "Alkaline earth","Atomic no: 20", R.drawable.calcium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Scandium",  "Transition metals","Atomic no: 21", R.drawable.scandium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Titanium",  "Transition metals","Atomic no: 22", R.drawable.titanium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Vanadium",  "Transition metals","Atomic no: 23", R.drawable.vanadium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Chromium",  "Transition metals","Atomic no: 24", R.drawable.chromium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Manganese",  "Transition metals","Atomic no: 25", R.drawable.manganese_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Iron",  "Transition metals", "Atomic no: 26",R.drawable.iron_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Cobalt",  "Transition metals","Atomic no: 27", R.drawable.cobalt_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Nickel",  "Transition metals", "Atomic no: 28",R.drawable.nickel_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Copper",  "Transition metals","Atomic no: 29", R.drawable.copper_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Zinc",  "Transition metals", "Atomic no: 30",R.drawable.zinc_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Gallium",  "Post transition","Atomic no: 31", R.drawable.gallium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Germanium",  "Metalloids", "Atomic no: 32",R.drawable.germanium_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Arsenic",  "Metalloids", "Atomic no: 33",R.drawable.arsenic_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Selenium",  "Non metals", "Atomic no: 34",R.drawable.selenium_photo_min,R.drawable.non_metals));
        SearchHolderList.add(new SearchHolder(1, "Bromine",  "Halogens", "Atomic no: 35",R.drawable.bromine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Krypton",  "Noble gases", "Atomic no: 36",R.drawable.krypton_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(1, "Rubidium",  "Alkali metals", "Atomic no: 37",R.drawable.rubidium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Strontium",  "Alkaline earth","Atomic no: 38", R.drawable.strontium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Yttrium",  "Transition metals","Atomic no: 39", R.drawable.yttrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Zirconium",  "Transition metals","Atomic no: 40", R.drawable.zirconium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Niobium",  "Transition metals", "Atomic no: 41",R.drawable.niobium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Molybdenum",  "Transition metals", "Atomic no: 42",R.drawable.molybdenum_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Technetium",  "Transition metals", "Atomic no: 43",R.drawable.technetium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Ruthenium",  "Transition metals", "Atomic no: 44",R.drawable.ruthenium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Rhodium",  "Transition metals", "Atomic no: 45",R.drawable.rhodium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Palladium",  "Transition metals", "Atomic no: 46",R.drawable.palladium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Silver",  "Transition metals", "Atomic no: 47",R.drawable.silver_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Cadmium",  "Transition metals", "Atomic no: 48",R.drawable.cadmium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Indium",  "Post transition", "Atomic no: 49",R.drawable.indium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Tin",  "Post transition", "Atomic no: 50",R.drawable.tin_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Antimony",  "Metalloids", "Atomic no: 51",R.drawable.antimony_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Tellurium",  "Metalloids", "Atomic no: 52",R.drawable.tellurium_photo_min,R.drawable.metalloids));
        SearchHolderList.add(new SearchHolder(1, "Iodine",  "Halogens", "Atomic no: 53",R.drawable.iodine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Xenon",  "Noble gases", "Atomic no: 54",R.drawable.xenon_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(1, "Cesium",  "Alkali metals","Atomic no: 55", R.drawable.cesium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Barium",  "Alkaline earth", "Atomic no: 56",R.drawable.barium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Lanthanum",  "Lanthanides","Atomic no: 57", R.drawable.lanthanum_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Cerium",  "Lanthanides", "Atomic no: 58",R.drawable.cerium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Praseodymium",  "Lanthanides","Atomic no: 59", R.drawable.praseodymium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Neodymium",  "Lanthanides", "Atomic no: 60",R.drawable.neodymium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Promethium",  "Lanthanides", "Atomic no: 61",R.drawable.promethium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Samarium",  "Lanthanides","Atomic no: 62", R.drawable.samarium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Europium",  "Lanthanides", "Atomic no: 63",R.drawable.europium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Gadolinium",  "Lanthanides", "Atomic no: 64",R.drawable.gadolinium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Terbium",  "Lanthanides", "Atomic no: 65",R.drawable.terbium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Dysprosium",  "Lanthanides","Atomic no: 66", R.drawable.dysprosium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Holmium",  "Lanthanides", "Atomic no: 67",R.drawable.holmium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Erbium",  "Lanthanides", "Atomic no: 68",R.drawable.erbium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Thulium",  "Lanthanides", "Atomic no: 69",R.drawable.thulium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Ytterbium",  "Lanthanides","Atomic no: 70", R.drawable.yttrbium_photo_min,R.drawable.lanthanides));
        SearchHolderList.add(new SearchHolder(1, "Lutetium",  "Lanthanides", "Atomic no: 71",R.drawable.lutetium_photo_min,R.drawable.lanthanides));

        SearchHolderList.add(new SearchHolder(1, "Hafnium",  "Transition metals","Atomic no: 72", R.drawable.hafnium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Tantalum",  "Transition metals","Atomic no: 73", R.drawable.tantalum_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Tungsten",  "Transition metals","Atomic no: 74", R.drawable.tungsten_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Rhenium",  "Transition metals","Atomic no: 75", R.drawable.rhenium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Osmium",  "Transition metals","Atomic no: 76", R.drawable.osmium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Iridium",  "Transition metals","Atomic no: 77", R.drawable.iridium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Platinum",  "Transition metals","Atomic no: 78", R.drawable.platinum_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Gold",  "Transition metals","Atomic no: 79", R.drawable.gold_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Mercury",  "Transition metals","Atomic no: 80", R.drawable.mercury_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Thallium",  "Post transition", "Atomic no: 81",R.drawable.thallium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Lead",  "Post transition","Atomic no: 82", R.drawable.lead_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Bismuth",  "Post transition", "Atomic no: 83",R.drawable.bismuth_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Polonium",  "Metalloids", "Atomic no: 84",R.drawable.polonium_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Astatine",  "Halogens","Atomic no: 85", R.drawable.astatine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Radon",  "Noble gases","Atomic no: 86", R.drawable.radon_photo_min,R.drawable.noble_gases));

        SearchHolderList.add(new SearchHolder(1, "Francium",  "Alkali metals","Atomic no: 87", R.drawable.francium_photo_min,R.drawable.alkali_metals));
        SearchHolderList.add(new SearchHolder(1, "Radium",  "Alkaline earth", "Atomic no: 88",R.drawable.radium_photo_min,R.drawable.alkaline_earth_metals));
        SearchHolderList.add(new SearchHolder(1, "Actinium",  "Actinides", "Atomic no: 89",R.drawable.actinium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Thorium",  "Actinides","Atomic no: 90", R.drawable.thorium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Protactinium",  "Actinides","Atomic no: 91", R.drawable.protactinium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Uranium",  "Actinides","Atomic no: 92", R.drawable.uranium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Neptunium",  "Actinides", "Atomic no: 93",R.drawable.neptunium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Plutonium",  "Actinides", "Atomic no: 94",R.drawable.plutonium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Americium",  "Actinides", "Atomic no: 95",R.drawable.americium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Curium",  "Actinides", "Atomic no: 96",R.drawable.curium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Berkelium",  "Actinides","Atomic no: 97", R.drawable.berkelium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Californium",  "Actinides", "Atomic no: 98",R.drawable.californium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Einsteinium",  "Actinides", "Atomic no: 99",R.drawable.einsteinium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Fermium",  "Actinides", "Atomic no: 100",R.drawable.fermium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Mendelevium",  "Actinides", "Atomic no: 101",R.drawable.mendelevium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Nobelium",  "Actinides", "Atomic no: 102",R.drawable.nobelium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Lawrencium",  "Actinides", "Atomic no: 103",R.drawable.lawrencium_photo_min,R.drawable.actinoides));
        SearchHolderList.add(new SearchHolder(1, "Rutherfordium",  "Transition metals", "Atomic no: 104",R.drawable.rutherfordium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Dubnium",  "Transition metals", "Atomic no: 105",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Seaborgium",  "Transition metals", "Atomic no: 106",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Bohrium",  "Transition metals", "Atomic no: 107",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Hassium",  "Transition metals", "Atomic no: 108",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Meitnerium",  "Transition metals", "Atomic no: 109",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Darmstadtium",  "Transition metals", "Atomic no: 110",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Roentgenium",  "Transition metals", "Atomic no: 111",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Copernicium",  "Transition metals", "Atomic no: 112",R.drawable.bohrium_photo_min,R.drawable.transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Nihonium",  "Post transition", "Atomic no: 113",R.drawable.nihonium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Flerovium",  "Post transition", "Atomic no: 114",R.drawable.nihonium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Moscovium",  "Post transition", "Atomic no: 115",R.drawable.nihonium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Livermorium",  "Post transition", "Atomic no: 116",R.drawable.nihonium_photo_min,R.drawable.post_transition_metals));
        SearchHolderList.add(new SearchHolder(1, "Tennessine",  "Halogens", "Atomic no: 117",R.drawable.tennessine_photo_min,R.drawable.halogens));
        SearchHolderList.add(new SearchHolder(1, "Oganesson",  "Noble gases","Atomic no: 118", R.drawable.oganesson_photo_min,R.drawable.noble_gases));


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final MenuItem search_item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) search_item.getActionView();
        changeSearchViewTextColor(searchView);
        searchView.setFocusable(true);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                search_item.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String string) {
                final  List<SearchHolder> filtermodelist2=filter(SearchHolderList,string);
                adapter2.setFilter(filtermodelist2);
                return true;
            }
        });
        return true;
    }

    private List<SearchHolder> filter(List<SearchHolder> pl, String query) {
        query=query.toLowerCase();
        final List<SearchHolder> filteredModeList=new ArrayList<>();
        for (SearchHolder model:pl)
        {
            final String text=model.getName().toLowerCase();
            if (text.startsWith(query))
            {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

    //for changing the text color of searchview
    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

