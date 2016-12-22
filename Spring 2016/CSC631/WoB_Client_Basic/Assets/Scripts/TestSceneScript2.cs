using UnityEngine;
using System.Collections;

/*upon execution
 * 	immediately instantiate 5 different species of 
 * 	your choosing at random positions on the
 * 	terrain
 * 
 * 	instantiate species using keyboard inputs while 
 * 	the game is running. create 3 different species
 * 	using 3 different keys
*/



public class TestSceneScript2 : MonoBehaviour {
	
	private System.Random rand;
	private GameObject someSpecies;
	private string [] species;
	private Vector3 speciesPosition;

	public Renderer rend;

	void InstantiateNewSpecies (int i) {
		Material speciesMaterial = (Material)GameObject.Instantiate (Resources.Load (Constants.TEXTURE_RESOURCES_PATH + "Species/Materials/" + species[i]));
		
		rend = GetComponent<Renderer>();
		rend.enabled = true;

		someSpecies.transform.GetChild (0).GetComponent<Renderer>().material = speciesMaterial;

		speciesPosition = new Vector3(rand.Next(0,40),25,rand.Next(0,40));
		
		GameObject.Instantiate (someSpecies, speciesPosition, Quaternion.identity);

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

		for (int i = 0; i<5; i++) {
			InstantiateNewSpecies (i);
		}
	
	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetKeyDown(KeyCode.A) ){
			InstantiateNewSpecies(0);
		}
		if(Input.GetKeyDown(KeyCode.S) ){
			InstantiateNewSpecies(1);
		}
		if(Input.GetKeyDown(KeyCode.D) ){
			InstantiateNewSpecies(3);
		}
	}
}
