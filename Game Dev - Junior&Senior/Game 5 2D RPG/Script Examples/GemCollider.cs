using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GemCollider : MonoBehaviour
{
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (gameObject.tag == "gem1")
        {
            Destroy(GameObject.Find("Gem 1"));
            Maze.gem1col = true;
        }
        if (gameObject.tag == "gem2")
        {
            Destroy(GameObject.Find("Gem 2"));
            Maze.gem2col = true;
        }
        if (gameObject.tag == "gem3")
        {
            Destroy(GameObject.Find("Gem 3"));
            Maze.gem3col = true;
        }
    }
}
