using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Goal : MonoBehaviour
{
    public GameObject goalWall;
    void OnCollisionEnter2D()
    {
        Destroy(goalWall.gameObject);
    }
}
