using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using UnityEngine;
using UnityEngine.UI;

public class AttackScript : MonoBehaviour
{
    public Animator animator;
    private float attackTime = 0;
    public float startTimeAttack = .5f;

    private Transform attackUp;
    private Transform attackUpRight;
    private Transform attackUpLeft;
    private Transform attackLeft;
    private Transform attackRight;
    private Transform attackBottom;
    private Transform attackBottomRight;
    private Transform attackBottomLeft;
    private Vector3 attackPosUp;
    private Vector3 attackPosUpRight;
    private Vector3 attackPosUpLeft;
    private Vector3 attackPosLeft;
    private Vector3 attackPosRight;
    private Vector3 attackPosBottom;
    private Vector3 attackPosBottomRight;
    private Vector3 attackPosBottomLeft;
    public AudioSource audioSource;
    public GameObject Arrow;
    public int thrust = 10;


    void Start()
    {
        attackUp = GameObject.FindWithTag("Top").transform;
        attackUpRight = GameObject.FindWithTag("TopRight").transform;
        attackUpLeft = GameObject.FindWithTag("TopLeft").transform;
        attackLeft = GameObject.FindWithTag("Left").transform;
        attackRight = GameObject.FindWithTag("Right").transform;
        attackBottom = GameObject.FindWithTag("Bottom").transform;
        attackBottomRight = GameObject.FindWithTag("BottomRight").transform;
        attackBottomLeft = GameObject.FindWithTag("BottomLeft").transform;

    }
    void FixedUpdate()
    {
        
        attackPosUp = attackUp.position;
        attackPosUpRight = attackUpRight.position;
        attackPosUpLeft = attackUpLeft.position;
        attackPosLeft = attackLeft.position;
        attackPosRight = attackRight.position;
        attackPosBottom = attackBottom.position;
        attackPosBottomRight = attackBottomRight.position;
        attackPosBottomLeft = attackBottomLeft.position;

        if (attackTime <= 0)
        {
            if (Input.GetKey(KeyCode.Keypad8))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosUp, transform.rotation * Quaternion.Euler(0f, 0f, 0f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(0, thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad2))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosBottom, transform.rotation * Quaternion.Euler(0f, 0f, 180f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(0, -thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad4))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosLeft, transform.rotation * Quaternion.Euler(0f, 0f, 90f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(-thrust, 0);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad6))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosRight, transform.rotation * Quaternion.Euler(0f, 0f, 270f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(thrust, 0);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad7))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosUpLeft, transform.rotation * Quaternion.Euler(0f, 0f, 45f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(-thrust, thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad9))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosUpRight, transform.rotation * Quaternion.Euler(0f, 0f, 315f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(thrust, thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad1))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosBottomLeft, transform.rotation * Quaternion.Euler(0f, 0f, 135f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(-thrust, -thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
            else if (Input.GetKey(KeyCode.Keypad3))
            {
                GameObject instansedArrow = GameObject.Instantiate(Arrow, attackPosBottomRight, transform.rotation * Quaternion.Euler(0f, 0f, 225f));
                instansedArrow.GetComponent<Rigidbody2D>().velocity = new Vector2(thrust, -thrust);
                audioSource.Play();
                attackTime = startTimeAttack;
            }
        }
        else
        {
            attackTime -= Time.deltaTime;
        }
    }
}