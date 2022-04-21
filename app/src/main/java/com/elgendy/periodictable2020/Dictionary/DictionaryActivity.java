package com.elgendy.periodictable2020.Dictionary;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elgendy.periodictable2020.SharedPref;

import java.util.ArrayList;
import java.util.List;

import com.elgendy.periodictable2020.R;
import com.elgendy.periodictable2020.SharedPref;

public class DictionaryActivity extends AppCompatActivity {

    SharedPref sharedpref;
    RecyclerView recyclerView;
    List<DictionaryHolder> DictionaryHolderList = new ArrayList<>();
    SearchView searchView;
    DictionaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new SharedPref(this);
        if (sharedpref.loadNightModeState() == true) { setTheme(R.style.DarkTheme); }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Toolbar toolbar = findViewById(R.id.toolbar_definition);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerDictionary);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DictionaryAdapter(DictionaryHolderList, DictionaryActivity.this);
        recyclerView.setAdapter(adapter);

        DictionaryHolderList.add(new DictionaryHolder("Actinides:", "The actinides fill the second horizontal strip at the foot of the table. Named after their first element, actinium, they are all highly radioactive. So much so, that natural reserves of many of these elements have decayed away to nothing."));
        DictionaryHolderList.add(new DictionaryHolder("Alkali metals:", "This “group 1” of metals occupies the far-left column of the periodic table. They are all soft, but solid metals at room temperature, and are highly reactive."));
        DictionaryHolderList.add(new DictionaryHolder("Alkaline earth metals:", "The alkaline earth metals are silver-white metals at room temperature. The name is a term that refers to the naturally occurring oxides of these elements."));
        DictionaryHolderList.add(new DictionaryHolder("Atom:", "The smallest component of an element having it’s chemical properties, it consist from nucleus containing combination of neutrons and protons and there is electrons rotating around the nucleus by electrical attraction; the number of protons determines the identity of the element."));
        DictionaryHolderList.add(new DictionaryHolder("Atomic number:", "the number of protons in the nucleus of an atom, which is characteristic of a chemical element and determines its place in the periodic table."));
        DictionaryHolderList.add(new DictionaryHolder("Atomic radius:", "It is half the distance between the centers of two similar atoms in diatomic molecule."));
        DictionaryHolderList.add(new DictionaryHolder("Atomic weight:", "Atomic mass or atomic weight is the average mass of atoms of an element, calculated using the relative abundance of isotopes in a naturally-occurring element."));
        DictionaryHolderList.add(new DictionaryHolder("Avogadro constant:", "The constant 6.022 × 10.23 representing the number of atoms, molecules or ions in one mole of substance."));
        DictionaryHolderList.add(new DictionaryHolder("Beta particles:", "An electron or positron emitted from an atomic nucleus in certain type of radioactive decay."));
        DictionaryHolderList.add(new DictionaryHolder("Covalent radius:", "It's the distance between the nuclei of the two-bonded atom."));
        DictionaryHolderList.add(new DictionaryHolder("Electron affinity:", "It is the amount of energy released when an extra electron is adding to the atom."));
        DictionaryHolderList.add(new DictionaryHolder("Electron shell:", "A grouping of electrons surrounding the nucleus of an atom."));
        DictionaryHolderList.add(new DictionaryHolder("Electron:", "An elementary particle having a negative charge, it’s mass is smaller than protons by 1800 time and rotating around the nucleus of atom."));
        DictionaryHolderList.add(new DictionaryHolder("Electronegativity:", "It is the tendency of the atom to attract the electrons of chemical bond to itself."));
        DictionaryHolderList.add(new DictionaryHolder("Electronic configuration:","Arrangement or distribution of electrons in the orbitals of an atom."));
        DictionaryHolderList.add(new DictionaryHolder("Fusion heat:", "The amount of heat required to convert a solid at its melting point into a liquid without an increase in temperature."));
        DictionaryHolderList.add(new DictionaryHolder("Gamma radiation:", "A photon of penetrating electromagnetic radiation emitted from atomic nucleus."));
        DictionaryHolderList.add(new DictionaryHolder("Half-life time:", "The time taken for the radioactivity of a specified isotope to fall to half its original value."));
        DictionaryHolderList.add(new DictionaryHolder("Halogens:", "The halogens, known as group 17, are the only group to contain all three principal states of matter at room temperature: gas (fluorine, chlorine), liquid (bromine) and solid (iodine, astatine)."));
        DictionaryHolderList.add(new DictionaryHolder("Ionization energy:", "It is the amount of energy required to remove the most loosely bound electron completely from an isolated atom."));
        DictionaryHolderList.add(new DictionaryHolder("Lanthanides:", "The lanthanides elements occupy a horizontal strip normally appended at the foot of the periodic table. Named after lanthanum, the first element in the series, they are generally found in less."));
        DictionaryHolderList.add(new DictionaryHolder("Magnetic field:", "A region of space near a magnetic, electric current of moving charged particle in which a magnetic force acts on any other magnetic, electric current or moving charged particles."));
        DictionaryHolderList.add(new DictionaryHolder("Magnetic susceptibility:", "Magnetic susceptibility is a measure of the propensity of a material to become magnetized when placed in a magnetic field."));
        DictionaryHolderList.add(new DictionaryHolder("Main transition metals:", "The transition metals occupy the center of the periodic table. They are harder than the alkali metals, less reactive and are generally good conductors of both heat and electrical current."));
        DictionaryHolderList.add(new DictionaryHolder("Metalloids:", "The metalloid elements form a line between the metals and nonmetals in the periodic table. Their electrical conductivity is intermediate between the two groups, leading to their use in semiconductor electronics."));
        DictionaryHolderList.add(new DictionaryHolder("Neutrons:", "An elementary particle having no charge, mass slightly greater the protons, and spin of ½; neutrons found in all elements except hydrogen."));
        DictionaryHolderList.add(new DictionaryHolder("Noble gases: ", "The noble gases are non-metals occupying group 18 of the table. They are all gaseous at room temperature and share the properties of being colorless, odorless and unreactive. Including neon, argon and xenon, they have applications in lighting and welding."));
        DictionaryHolderList.add(new DictionaryHolder("Nonmetals:", "They display a wide range of chemical properties and reactivities. They have high ionization energies and electronegativities and are generally poor conductors of heat and electricity. Most non-metals can gain electrons easily. They have lower melting points, boiling points and densities than the metal elements."));
        DictionaryHolderList.add(new DictionaryHolder("Nuclear fusion:", "A thermonuclear reaction in which nuclei of light atoms join to form a heavier atom, as combination of deuterium atoms to form helium atoms."));
        DictionaryHolderList.add(new DictionaryHolder("Periodic table:", "It’s the ascending arrangement for the element according to their atomic number and atomic weight."));
        DictionaryHolderList.add(new DictionaryHolder("Post transition metals:", "Lying in a triangular region to the right of the transition metals, the post transition metals are soft metals that mostly have low melting and boiling points. They also include mercury, which is liquid at room temperature."));
        DictionaryHolderList.add(new DictionaryHolder("Proton:", "A positively charged elementary particles that is a fundamental constituent of all atomic nuclei. It is lightest and most stable baryon, having a charge equal in magnitude to that of the electron, a spin of ½."));
        DictionaryHolderList.add(new DictionaryHolder("Radioactivity:", "A Spontaneous emission of radiation, either directly from unstable atomic nuclei or because of a nuclear reaction. The radiation, including alpha particles, nucleons, electrons, and gamma rays, emitted by a radioactive substance."));
        DictionaryHolderList.add(new DictionaryHolder("Resistivity:", "Is a fundamental property that quantifies how strongly a given material opposes the flow of electric current."));
        DictionaryHolderList.add(new DictionaryHolder("Short electronic configuration:", "Arrangement of electrons in the orbitals of an atom starting from the nearest noble gas."));
        DictionaryHolderList.add(new DictionaryHolder("Specific heat:", "The specific heat is the amount of heat per unit mass required to raise the temperature by one-degree celsius."));
        DictionaryHolderList.add(new DictionaryHolder("Van der waals radius:", "The forces of attraction which hold an individual molecule together (for example, the covalent bonds) are known as intramolecular attractions."));
        DictionaryHolderList.add(new DictionaryHolder("Vaporization heat:", "The amount of heat required to convert a liquid into a gas at constant temperature and pressure."));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile, menu);

        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final  List<DictionaryHolder> filtermodelist=filter(DictionaryHolderList,newText);
                adapter.setfilter(filtermodelist);
                return true;
            }
        });

        return true;
    }
    private List<DictionaryHolder> filter(List<DictionaryHolder> pl, String query) {
        query=query.toLowerCase();
        final List<DictionaryHolder> filteredModeList=new ArrayList<>();
        for (DictionaryHolder model:pl)
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