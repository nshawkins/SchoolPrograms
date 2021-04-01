	
	.data	# Data section
		# Assembler directive - does not result in code
		
        enterA:  .asciiz "Enter integer A: "
        enterB:  .asciiz "Enter integer B: "
        agr:     .asciiz "A is greater than B!"
        bgr:     .asciiz "B is greater than A!"
        abeq:    .asciiz "A and B are equal!"
        intA:    .word 0
        intB:    .word 0

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a label
			
main:

#lw $t0, intA #lw is load word
#lw $t1, intB

addi $v0, $zero, 4     # system call code to print string
la   $a0, enterA       # place the address of the string to call in argument register
syscall                # The actual system call
  
addi $v0, $zero, 5     # System call code to read a int
syscall 

add $t0, $0, $v0      # saves v0 to t0
#lw $t0, ($v0)
#move $v0, $t0

#sw $t0, intA          # save intA to register 0
#syscall

addi $v0, $zero, 4     # system call code to print string
la   $a0, enterB       # place the address of the string to call in argument register
syscall                # The actual system call
   
addi $v0, $zero, 5     # System call code to read a int
syscall                # Actual system call

add $t1, $0, $v0
#sw $t1, intB           # save intB to register 1
#syscall

beq $t0, $t1, abequals
slt $t2, $t0, $t1
beq $t2, $0, agreater

addi $v0, $zero, 4     # system call code to print string
la   $a0, bgr         # place the address of the string to call in argument register
syscall               # The actual system call
j Exit

abequals:
#print function and jexit
addi $v0, $zero, 4     # system call code to print string
la   $a0, abeq         # place the address of the string to call in argument register
syscall
j Exit

agreater:
addi $v0, $zero, 4     # system call code to print string
la   $a0, agr         # place the address of the string to call in argument register
syscall               # The actual system call
j Exit

Exit:			# Label for the exit routine	
li $v0,10		# $v0 is a special register, and if its loaded with 
# addi $v0, $0, 10
syscall			# value 10, it means the program should terminate
			# All our programs should have this
