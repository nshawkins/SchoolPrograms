# Comments in MIPS start with the pound or sharp symbol
# By Dr Alfa Nyandoro
# Fall 2019
# This program introduces MIPS highlighting the following
#     - 	sections of a MIPS assembly program
#	use of psuedo-instructions e.g li, la
#	special registers
#	syscall

	.data	# Data section
		# Assembler directive - does not result in code
        mystr: .ascii "Hello World! \n"
        qn:    .asciiz "What is your name?\n:"
        greet: .ascii "Welcome "
        intA: .word 7
        intB: .word 3

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:

#print Hello World

#addi $v0, $zero, 4
#la   $a0, mystr
#syscall

addi $v0, $zero, 4     # system call code to print string
la   $a0, qn           # place the address of the string to call in argument register
syscall                # The actual system call

addi  $a1, $0, 20      # Length of string to read from the keyboard     
addi $v0, $zero, 8     # System call code to read a string
syscall                # Actual system call



addi $v0, $zero, 4
syscall
                        # $a0 is prepopulated with $a0 - address of string to print (from syscall above)
                        # Actual system call

lw $t0, intA #lw is load word
lw $t1, intB
add $t0, $t0, $t1

sw $t0, intA #sw is store word
addi, $v0, $zero, 1
lw $a0, intA
syscall



Exit:			# Label for the exit routine	
li $v0,10		# $v0 is a special register, and if its loaded with 
# addi $v0, $0, 10
syscall			# value 10, it means the program should terminate
			# All our programs should have this
