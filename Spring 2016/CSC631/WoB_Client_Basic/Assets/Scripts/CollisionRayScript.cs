using UnityEngine;
using System.Collections;

/*
Script should respond to mouse inputs.
Using collision rays, perform collision detection with terrain whenever mouse is clicked.
Instantiate a species at that location.
*/

public class CollisionRayScript : MonoBehaviour {

    private System.Random rand;
    private GameObject someSpecies;
    private string [] species;
    private Vector3 speciesPosition;
    public Renderer rend;

    void InstantiateNewSpecies (int i, Vector3 position) {
        Material speciesMaterial = (Material)GameObject.Instantiate (Resources.Load (Constants.TEXTURE_RESOURCES_PATH + "Species/Materials/" + species[i]));
        
        // rend = GetComponent<Renderer>();
        // rend.enabled = true;

        someSpecies.transform.GetChild (0).GetComponent<Renderer>().material = speciesMaterial;

        // speciesPosition = new Vector3(rand.Next(0,200),70,rand.Next(0,200));
        
        Instantiate (someSpecies, position, Quaternion.identity);

        someSpecies.name = species[i];
    }
    // Use this for initialization
    void Start () {
        rand = new System.Random ();

        species = new string[] {
            "Aardvark",
            "African Elephant",
            "Black Rhinoceros",
            "Buffalo",
            "Hippopotamus"
        };

        someSpecies = (GameObject)Resources.Load (Constants.PREFAB_RESOURCES_PATH + "New");

    }
    
    // Update is called once per frame
    void Update () {
        if(Input.GetButtonDown("Fire1"))
        {
            Ray ray;
            RaycastHit hit;
            ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            int i = 0;
            if (Physics.Raycast(ray, out hit, 100.0f))
            {
                i = rand.Next(0,4);
                InstantiateNewSpecies(i, hit.point);
                Debug.Log ("Species name: " + species[i]);
                Debug.Log ("New name: " + someSpecies.name);
            }
        }
    }
}
