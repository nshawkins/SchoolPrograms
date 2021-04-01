using System.Collections;
using System.Collections.Generic;
using System.Security.Cryptography;
using UnityEngine;
using UnityEngine.Events;

public class PlayerMovement : MonoBehaviour
{

    public int playerSpeed = 10;
    private float moveX;
    private float moveY;
    public Rigidbody2D rb;
    public Animator animator;
    public int thrust = 500;
    private bool facingRight = false;

    // Start is called before the first frame update
    void Start()
    {
        rb = gameObject.GetComponent<Rigidbody2D>();
        animator.SetInteger("walkX", 0);
        animator.SetInteger("walkY", 0);
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        PlayerMove();
    }

    void PlayerMove()
    {
        //controls
        if (Input.GetKey(KeyCode.A))
        {
            moveX = -1;
            //facingRight = false;
        }
        if (Input.GetKey(KeyCode.D))
        {
            moveX = 1;
            //facingRight = true;
        }
        if (Input.GetKey(KeyCode.S))
        {
            moveY = -1;
        }
        if (Input.GetKey(KeyCode.W))
        {
            moveY = 1;
        }
        if (Input.GetKeyDown(KeyCode.Space))
        {
            dash();
        }
        else
        {
            rb.velocity = new Vector2(moveX * playerSpeed, rb.velocity.y);
            rb.velocity = new Vector2(rb.velocity.x, moveY * playerSpeed);
        }
        /*
        if (moveX == -1 && !facingRight)
        {
            FlipPlayer();
        }
        else if (moveX == 1 && facingRight)
        {
            FlipPlayer();
        }*/
        animator.SetInteger("walkX", (int)moveX);
        animator.SetInteger("walkY", (int)moveY);
        moveX = 0;
        moveY = 0;
    }
    void FlipPlayer()
    {
        facingRight = !facingRight;
        Vector2 localScale = gameObject.transform.localScale;
        localScale.x *= -1;
        transform.localScale = localScale;
    }
    void dash()
    {
        rb.velocity = new Vector2(moveX * thrust, rb.velocity.y);
        rb.velocity = new Vector2(rb.velocity.x, moveY * thrust);
    }

}
