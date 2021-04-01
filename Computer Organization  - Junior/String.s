.data	# Data section
		# Assembler directive - does not result in code
        mystr: .ascii "Text returned: \n"
        qn:    .asciiz "Enter a string:\n:"

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:

addi $v0, $zero, 4     # system call code to print string
la   $a0, qn           # place the address of the string to call in argument register
syscall                # The actual system call

addi  $a1, $0, 20      # Length of string to read from the keyboard     
addi $v0, $zero, 8     # System call code to read a string
syscall                # Actual system call

addi $v0, $zero, 4     # system call code to print string
la   $a0, mystr        # place the address of the string to call in argument register
syscall               # The actual system call

Exit:
li $v0,10		# $v0 is a special register, and if its loaded with 
# addi $v0, $0, 10
syscall			# value 10, it means the program should terminate
			# All our programs should have this
