using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyMove : MonoBehaviour
{
    public Rigidbody2D rb;
    private float EnemySpeedx;
    private float EnemySpeedy;
    private int counter = 0;
    public int maxTime;
    // Start is called before the first frame update
    void Start()
    {
        rb = gameObject.GetComponent<Rigidbody2D>();
        counter = maxTime;
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        if(counter > maxTime)
        {
            EnemySpeedx = UnityEngine.Random.Range(-4f, 4f);
            EnemySpeedy = UnityEngine.Random.Range(-4f, 4f);
            counter = 0;
        }
        else
        {
            counter++;
        }
        rb.velocity = new Vector2(EnemySpeedx, rb.velocity.y);
        rb.velocity = new Vector2(rb.velocity.x, EnemySpeedy);
    }
}
