using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Health : MonoBehaviour
{
    private float hitTime = 0;
    public float startTimeHit = .5f;
    private int health = 3;
    public string sceneName = "Town";
    private GameObject heart1;
    private GameObject heart2;
    private GameObject heart3;

    private void Start()
    {
        heart1 = GameObject.Find("Heart 1");
        heart2 = GameObject.Find("Heart 2");
        heart3 = GameObject.Find("Heart 3");
    }
    private void Update()
    {
        hitTime -= Time.deltaTime;

        if(health == 3)
        {
            heart1.SetActive(true);
            heart2.SetActive(true);
            heart3.SetActive(true);
        }
        else if (health == 2)
        {
            heart1.SetActive(true);
            heart2.SetActive(true);
            heart3.SetActive(false);
        }
        else if (health == 1)
        {
            heart1.SetActive(true);
            heart2.SetActive(false);
            heart3.SetActive(false);
        }
        else if (health == 0)
        {
            heart1.SetActive(false);
            heart2.SetActive(false);
            heart3.SetActive(false);
            
            Destroy(GameObject.Find("Player"));
            StartCoroutine(ExecuteAfterTime(2));
        }
            
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag == "Enemy" && hitTime <= 0)
        {
            hitTime = startTimeHit;
            health -= 1;
        }
        if(collision.gameObject.tag == "Potion" && health < 3)
        {
            Destroy(collision.gameObject);
            health += 1;
        }
    }
    
    IEnumerator ExecuteAfterTime(float time) {
        Debug.Log("execute after time triggered");
        yield return new WaitForSeconds(time);
        SceneManager.LoadScene(sceneName);
    }
}
