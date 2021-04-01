using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Maze : MonoBehaviour
{
    public GameObject gem1;
    public GameObject gem2;
    public GameObject gem3;
    public GameObject door;
    public static bool gem1col = false;
    public static bool gem2col = false;
    public static bool gem3col = false;

    // Update is called once per frame
    void Update()
    {
        if(gem1col && gem2col && gem3col)
        {
            Destroy(door.gameObject);
        }
    }
}
